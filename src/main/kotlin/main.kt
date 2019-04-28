package SparkSimpleDemo

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext
import java.util.ArrayList



fun main() {
    System.setProperty("hadoop.home.dir", "c:/hadoop")
    Logger.getLogger("org.apache").level = Level.WARN

    val conf = SparkConf()
        .setAppName("startingSpark")
        .setMaster("local[*]")
    val sc = JavaSparkContext(conf)

    val inputData = ArrayList<Int>().apply {
        add(35)
        add(12)
        add(90)
        add(20)
    }

    val myRdd = sc.parallelize(inputData)
    val result = myRdd.reduce { value1, value2 -> value1 + value2 }
    val sqrtRdd = myRdd.map { Math.sqrt(it.toDouble()) }

    sqrtRdd.foreach{ println(it)}
    println(result)

    sc.close()
}