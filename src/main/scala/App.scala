package ru.lev.pyryanov

import com.databricks.spark.xml.XmlDataFrameReader
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

        val df = spark.read
            .option("rowTag", "item")
            .schema(schema)
            .xml("/opt/workspace/data/vedomosti.xml")

        println(df.count())

        df.write
            .format("jdbc")
            .option("driver", "org.postgresql.Driver")
            .option("url", "jdbc:postgresql://host.docker.internal:5430/test")
            .option("dbtable", "public.vedomosti")
            .option("user", "postgres")
            .option("password", "postgres")
            .mode("overwrite")
            .save()
    }
}
