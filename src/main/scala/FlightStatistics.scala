package com.naresh.spark

import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import java.sql.Date


object FlightStatistics {
//Question 1 calculation
  def displayFlightsPerMonthOnConsole(flightDF: DataFrame) {
    // Extracting month from date and doing grp by on month
    // Here i am assuming that i have  data of single year.
    // In case of multiple years of data we will have to use yyyy-MM as a format for month
//    Qn1.Find the total number of flights for each month.
    flightDF
      .withColumn("Month", month(col("date")))
      .groupBy("Month")
      .agg(count("flightId").as("Number of Flights"))
      .orderBy("Month")

    // Displaying the output on console
    flightDF.show()

  }
//  Qn2.Find the names of the 100 most frequent flyers.
  //Question 2 calculation
  def displayFrequentFlyersOnConsole(flightDF: DataFrame, passengersDF: DataFrame) {
    val flightPassengersCountDF = flightDF.groupBy("passengerId").agg(count("flightId").
      alias("Number of Flights"))
    // Using dense_rank to handle the flyers with similar number of flights
    val windowSpec = Window.orderBy(col("Number of Flights").desc)
    val rankedDF = flightPassengersCountDF.withColumn("rnk", dense_rank().over(windowSpec))
    // filtering only top100 flyers
    val top100 = rankedDF.filter(col("rnk") <=100)
     top100.join(passengersDF,"passengerId").
     select("passengerId", "Number of Flights","firstName","lastName").
     orderBy(desc("Number of Flights")).show()
  }
//  Qn3.Find the greatest number of countries a passenger has been in without being in the UK. For example,
//  if the countries a passenger was in were: UK -> FR -> US -> CN -> UK -> DE -> UK, the correct answer would be 3 countries.
  //Question 3 calculation
  def displayCountryVisitsOnConsole(flightDF: DataFrame)
                                    {
    val nonUKDF=flightDF
      .filter(col("from") =!= "UK" && col("to") =!= "UK")
      .groupBy("passengerId")
      .agg(size(collect_set("to")).as("Countries"))
    val lengthDF = nonUKDF.withColumn("runLen", col("Countries"))

    val maxRunPasengerDF = lengthDF.groupBy("passengerID").agg(max("runLen").alias("Longest Run"))
    maxRunPasengerDF.orderBy(col("Longest Run").desc).show()

  }
//  Qn4.Find the passengers who have been on more than 3 flights together.
  //Question 4 calculation
  def displayFlightsTogetherOnConsole(flightDF: DataFrame) {
    passangersFlightTogetherDFUtility(flightDF, 3).
      select(col("df1.passengerId").alias("Passenger 1 ID"),
        col("df2.passengerId").alias("Passenger 2 ID"), col("Number of flights together")).show()
  }



//   Qn5.Find the passengers who have been on more than N flights together within the range (from,to).
//  //Qn5 Calculation
  def displayFlightsTogetherWithDateRangeOnConsole(atLeastNTimes: Int, from: Date, to: Date, flightDF: DataFrame, spark: SparkSession): DataFrame = {
    // Convert SQL Date to String for filtering
    val fromStr = from.toString
    val toStr = to.toString

    // Filter flights based on the date range
    val dateFilteredFlights = flightDF
      .filter(
        to_date(col("date"), "yyyy-MM-dd")
          .between(lit(fromStr), lit(toStr))
      )
      .filter(col("flightId").isNotNull && col("passengerId").isNotNull)

    // Find pairs of passengers who have been on the same flights
    val passengersTogether = dateFilteredFlights.as("df1")
      .join(
        dateFilteredFlights.as("df2"),
        col("df1.flightId") === col("df2.flightId") && col("df1.passengerId") < col("df2.passengerId")
      )
      .groupBy(col("df1.passengerId").as("Passenger 1 ID"), col("df2.passengerId").as("Passenger 2 ID"))
      .agg(count("*").as("Number of Flights Together"))
      .filter(col("Number of Flights Together") > atLeastNTimes)

    // Add columns for the date range
    passengersTogether
      .withColumn("From", lit(fromStr))
      .withColumn("To", lit(toStr))
      .select("Passenger 1 ID", "Passenger 2 ID", "Number of Flights Together", "From", "To")
  }



  //Utility function
  private def passangersFlightTogetherDFUtility(flightDF: DataFrame, N: Integer) = {
    flightDF.as("df1")
      .join(flightDF.as("df2"),
        col("df1.flightId") === col("df2.flightId")
          && col("df1.passengerId") < col("df2.passengerId"))
      .groupBy("df1.passengerId", "df2.passengerId")
      .agg(count("*").as("Number of flights together"))
      .filter(col("Number of flights together") > N)
  }
}
