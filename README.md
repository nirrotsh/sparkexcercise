# Description
This is the exercises code for the (Excellent) UDEMY course "Apache Spark for Java Developers"  - [Lik here](https://www.udemy.com/share/100DmqAEQYc1hTQn4=/) 

However, there are two main differences:

### Using Gradle instead of  Maven
I prefer using Gradle to Maven, So I converted the exercise code to using gradle and the latest Apache Spark dependency versions
```
    compile group: 'org.apache.spark', name: 'spark-core_2.11', version: '2.3.0'
    compile group: 'org.apache.spark', name: 'spark-sql_2.11', version: '2.3.0'
    compile group: 'org.apache.hadoop', name: 'hadoop-hdfs', version: '2.2.0'
``` 

### Using Kotlin instead of JAVA
Kotlin is 100% compatible with Java, and I can even intermix java and Kotlin code (I left some of the original exercise code in JAVA, only my code was written in Kotlin)
But Kotlin provides a much more clean and concise syntax then Java.
Allowing me to focus on the functionality instead of the fluff and receieve a much shorter and clearer code.

So the following code in JAVA
```java
List<Integer> inputData = new ArrayList<>();
inputData.add(35);
inputData.add(12);
inputData.add(90);
inputData.add(20);

SparkConf conf = new SparkConf().setAppName("startingSpark").setMaster("local[*]");
JavaSparkContext sc = new JavaSparkContext(conf);
JavaRDD<Integer> myRdd = sc.parallelize(inputData);
Integer result = myRdd.reduce((value1, value2 ) -> value1 + value2 );
JavaRDD<Double> sqrtRdd = myRdd.map( value -> Math.sqrt(value) );

sqrtRdd.foreach( System.out::println );

System.out.println(result);
```

Becomes in Kotlin
```kotlin
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
```

Unlike Scala, you can keep the current java tools and code, and do not have to switch to a new language

### The code contains
#### main.kt
Under src/main/kotlin
It was simply a simple conversion of the basic chapter 4 exercise - just to verify for me that the code runs OK
It creates a very simple RDD made of a list of numbers, map them to a new RDD containing their square roots, and reduces the original RDD to calculate the sum of the numbers. 