package com.pa.demo


import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by dhiraj on 3/21/16.
  */
trait SparkInit {

  /**
    * Initilize Spark Context and SQL Context.
    *
    * @param args
    * @return
    */
  def initilizeSpark(args: Array[String], local: Boolean = false, addJarPath: Option[String] = None, params: Option[String] = None): (SparkContext, SQLContext) = {
    // setting up Spatk Conf

    val conf = if (local) {
      new SparkConf()
        .setMaster("local[6]")
        .setAppName("Data_diff_tool")
        .set("spark.driver.memory", "13g")

    } else {
      {
        new SparkConf().setMaster(args(0)).setAppName("pa_sample").setJars(Array(args(1)))
      }
    }

    // conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    //conf.set("spark.shuffle.blockTransferService", "nio")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)
    (sc, sqlContext)
  }
}

