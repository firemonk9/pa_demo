package com.pa.demo


/**
  * Created by dhiraj on 9/9/16.
  */
object Main extends SparkInit {

  def main(args: Array[String]) {

    println(" Starting the main....... ")

    val local = false //if (args.length > 0 && args(0) == "true") true else false

    val (sc, sqlContext) = initilizeSpark(Array(), local, None)

    val rdd = sc.parallelize(1 to 100).map(a => (a, a)).map(a => {
      //      val l = new com.pa.superAlgo.AlgoImplementer()
      //      l.add(a._1, a._2)
      a._1 + a._2
    })

    println(" this is the result.....:::  " + rdd.collect().toList)


    //    val path = if (args.length > 0) Some(args(0)) else None
    //    val df = if (path.isDefined) Some(sqlContext.read.parquet(path.get)) else None
    //    if(df.isDefined) {
    //      def parseStr(data:String):String = if(data != null && data.indexOf(".") > 0)  data.substring(0,data.indexOf(".")) else data
    //      df.get.rdd.toLocalIterator.foreach(a=> LargeMap.add(parseStr(a.get(0).toString) + parseStr(a.get(1).toString)  , a.get(2).toString.toInt))
    //    }
    //
    //
    ////    LargeMap.populate(25000000)
    //
    //    val intB = sc.broadcast(LargeMap.intOpenHashMap)
    //    val stringB = sc.broadcast(LargeMap.string2IntMap)
    //
    //
    //    println("  brodcasted count int " + intB.value.size())
    //    println("  brodcasted count string  " + stringB.value.size())


  }


}
