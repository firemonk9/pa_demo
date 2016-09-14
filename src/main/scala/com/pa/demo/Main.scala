package com.pa.demo


/**
  * Created by dhiraj on 9/9/16.
  */
object Main extends SparkInit {

  def main(args: Array[String]) {

    println(" Starting the main....... ")

    val local = false //if (args.length > 0 && args(0) == "true") true else false

    val (sc, sqlContext) = initilizeSpark(args, local, None)

    val rdd = sc.parallelize(1 to 100).map(a => (a, a)).map(a => {
      a._1 + a._2
    })

    println(" this is the result.....:::  " + rdd.collect().toList)



  }


}
// sbt package --> pademo_2.10-1.0.jar
// sbt assembly --> pa_demo.jar

// command to run --> java -cp /home/ec2-user/data/pa_demo.jar com.pa.demo.Main <SPARK_URL> /home/ec2-user/data/pademo_2.10-1.0.jar
