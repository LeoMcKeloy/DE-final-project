name := "DE-final-project"

version := "0.1"

scalaVersion := "2.12.10"

idePackagePrefix := Some("ru.lev.pyryanov")
libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-library" % "2.12.10",
    "org.apache.spark" %% "spark-core" % "3.2.2",
    "org.apache.spark" %% "spark-sql" % "3.2.2",
    "org.postgresql" % "postgresql" % "42.5.1",
    "com.databricks" %% "spark-xml" % "0.13.0"
)