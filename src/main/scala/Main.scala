package com.naresh.spark

import org.apache.spark.sql.SparkSession
import FlightStatistics._

object Main {
  def main(args: Array[String]): Unit = {
    // Initialize SparkSession
    implicit val spark: SparkSession = SparkSession.builder
      .appName("Quantexa Assignment")
      .master("local[*]")
      .config("spark.driver.bindAddress","127.0.0.1")
      .getOrCreate()


    // Load the data using DataLoader
    val flightData = DataLoader.loadFlightData(spark, "./src/main/resources/flightData.csv")
    val passengers = DataLoader.loadPassengerData(spark, "./src/main/resources/passengers.csv")

    // Calculate statistics using FlightStatistics
    val flightsPerMonth = calculateFlightsPerMonth(flightData)
    flightsPerMonth.show()

    val frequentFlyers = findFrequentFlyers(flightData, passengers)
    frequentFlyers.show()

    val countryVisits = calculateCountryVisits(flightData)
    countryVisits.show()

    val flightsTogether = calculateFlightsTogether(flightData)
    flightsTogether.show()

    val flightsTogetherWithinDate = flownTogether(3, "2017-01-01", "2017-12-31", flightData)
    flightsTogetherWithinDate.show()

    // Stop the Spark session
    spark.stop()
  }
}
