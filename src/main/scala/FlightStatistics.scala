package com.naresh.spark

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

object FlightStatistics {

  def calculateFlightsPerMonth(flightData: DataFrame)(implicit spark: SparkSession): DataFrame = {
    import spark.implicits._ // Import implicits for $ notation

    flightData
      .withColumn("Month", month(to_date(col("date"), "yyyy-MM-dd")))
      .groupBy("Month")
      .agg(count("flightId").as("Number of Flights"))
      .orderBy("Month")
  }

  def findFrequentFlyers(flightData: DataFrame, passengers: DataFrame)(implicit spark: SparkSession): DataFrame = {
    import spark.implicits._ // Import implicits for $ notation

    flightData
      .groupBy("passengerId")
      .agg(count("flightId").as("Number of Flights"))
      .join(passengers, "passengerId")
      .orderBy(desc("Number of Flights"))
      .limit(100)
  }

  def calculateCountryVisits(flightData: DataFrame)(implicit spark: SparkSession): DataFrame = {
    import spark.implicits._ // Import implicits for $ notation

    flightData
      .filter(col("from") =!= "UK" && col("to") =!= "UK")
      .groupBy("passengerId")
      .agg(size(collect_set("to")).as("Longest Run"))
  }

  def calculateFlightsTogether(flightData: DataFrame)(implicit spark: SparkSession): DataFrame = {
    import spark.implicits._ // Import implicits for $ notation

    flightData.as("df1")
      .join(flightData.as("df2"),
        $"df1.flightId" === $"df2.flightId" && $"df1.passengerId" < $"df2.passengerId")
      .groupBy("df1.passengerId", "df2.passengerId")
      .agg(count("*").as("Number of Flights"))
      .filter(col("Number of Flights") > 3)
  }

  def flownTogether(atLeastNTimes: Int, from: String, to: String, flightData: DataFrame)(implicit spark: SparkSession): DataFrame = {
    import spark.implicits._ // Import implicits for $ notation

    val dateFilteredFlights = flightData
      .filter(to_date(col("date"), "yyyy-MM-dd").between(from, to))

    dateFilteredFlights.as("df1")
      .join(dateFilteredFlights.as("df2"),
        $"df1.flightId" === $"df2.flightId" && $"df1.passengerId" < $"df2.passengerId")
      .groupBy("df1.passengerId", "df2.passengerId")
      .agg(count("*").as("Number of Flights"))
      .filter(col("Number of Flights") > atLeastNTimes)
  }
}
