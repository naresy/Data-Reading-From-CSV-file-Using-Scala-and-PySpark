package com.naresh.spark

import org.apache.spark.sql.SparkSession
import FlightStatistics._

import java.sql.Date

object Main {
  def main(args: Array[String]): Unit = {
    // Initialize SparkSession
    implicit val spark: SparkSession = SparkSession.builder
      .appName("Quantexa Assignment")
      .master("local[*]")
      .config("spark.driver.bindAddress","127.0.0.1")
      .getOrCreate()


    // Load the data using DataLoader
    val flightData = DataLoader.loadDataInDF(spark, "./src/main/resources/flightData.csv")
    val passengers = DataLoader.loadDataInDF(spark, "./src/main/resources/passengers.csv")
    // Display Question 1 Result onConsole
   displayFlightsPerMonthOnConsole(flightData)
    // Display Question 2 Result onConsole
 displayFrequentFlyersOnConsole(flightData, passengers)
    // Display Question 3 Result onConsole
displayCountryVisitsOnConsole(flightData)
    // Display Question 4 Result onConsole
displayFlightsTogetherOnConsole(flightData)
//Display Extra Credit Question Result onConsole
//    I assume number of counter is 3 and two random date
    val fromDate = Date.valueOf("2017-01-01")
    val toDate = Date.valueOf("2017-12-31")
    val flightsTogetherWithinDate = displayFlightsTogetherWithDateRangeOnConsole(3, fromDate, toDate, flightData, spark)
    flightsTogetherWithinDate.show()

  }
}