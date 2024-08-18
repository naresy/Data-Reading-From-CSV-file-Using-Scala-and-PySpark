package com.naresh.spark

import org.apache.spark.sql.{DataFrame, SparkSession}

object DataLoader {
  def loadDataInDF(spark: SparkSession, path: String): DataFrame = {
    spark.read.option("header", "true").option("inferSchema","true").csv(path)
  }

}