package com.naresh.spark

import org.apache.spark.sql.{DataFrame, SparkSession}

object DataLoader {
  def loadFlightData(spark: SparkSession, path: String): DataFrame = {
    spark.read.option("header", "true").csv(path)
  }

  def loadPassengerData(spark: SparkSession, path: String): DataFrame = {
    spark.read.option("header", "true").csv(path)
  }
}