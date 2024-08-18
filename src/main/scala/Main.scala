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
    // Calculate statistics using FlightStatistics
//    displayFlightsPerMonthOnConsole(flightData)
// displayFrequentFlyersOnConsole(flightData, passengers)
//displayCountryVisitsOnConsole(flightData)
//displayFlightsTogetherOnConsole(flightData)

    val fromDate = Date.valueOf("2017-01-01")
    val toDate = Date.valueOf("2017-12-31")

    val flightsTogetherWithinDate = flownTogether(3, fromDate, toDate, flightData, spark)
    flightsTogetherWithinDate.show()

  }
}