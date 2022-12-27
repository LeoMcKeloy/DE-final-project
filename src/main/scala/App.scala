package ru.lev.pyryanov

import com.databricks.spark.xml.XmlDataFrameReader
import org.apache.spark.sql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StringType, StructType}


object App {
    def main(args: Array[String]): Unit = {
        val spark = SparkSession
            .builder().appName("App")
            .master("local[1]")
            .getOrCreate()

        val schema = new StructType()
            .add("title",StringType)
            .add("link",StringType)
            .add("guid",StringType)
            .add("pdalink",StringType)
            .add("author",StringType)
            .add("category",StringType)
            .add("enclosure",StringType)
            .add("pubDate",StringType)
            .add("description", StringType)

        val dfVedomosti = spark.read
            .option("rowTag", "item")
            .schema(schema)
            .xml("/opt/workspace/data/vedomosti.xml")

        val dfTass = spark.read
            .option("rowTag", "item")
            .schema(schema)
            .xml("/opt/workspace/data/tass.xml")

        val dfLenta = spark.read
            .option("rowTag", "item")
            .schema(schema)
            .xml("/opt/workspace/data/lenta.xml")

        println(dfVedomosti.show(5))
        println(dfTass.show(5))
        println(dfLenta.show(5))

        writeToDB(dfVedomosti)
        writeToDB(dfTass)
        writeToDB(dfLenta)
    }

    def writeToDB(df: sql.DataFrame): Unit = {
        df.write
            .format("jdbc")
            .option("driver", "org.postgresql.Driver")
            .option("url", "jdbc:postgresql://host.docker.internal:5430/test")
            .option("dbtable", "public.data_mart")
            .option("user", "postgres")
            .option("password", "postgres")
            .mode("append")
            .save()
    }
}
