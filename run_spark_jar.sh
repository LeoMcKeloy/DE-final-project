#!/bin/bash

JAVA_HOME=/usr/local/openjdk-8
SPARK_MASTER_HOST=spark-master
PWD=/opt/workspace
HOME=/root
LANG=C.UTF-8
SPARK_MASTER_PORT=7077
SHARED_WORKSPACE=/opt/workspace
PYSPARK_PYTHON=python3
TERM=xterm
SCALA_HOME=/usr/bin/scala
SHLVL=1
SPARK_HOME=/usr/bin/spark-3.0.0-bin-hadoop3.2
PATH=/usr/local/openjdk-8/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/bin/scala/bin
JAVA_VERSION=8u342
_=/usr/bin/env
OLDPWD=/opt

/usr/bin/spark-3.0.0-bin-hadoop3.2/bin/spark-submit --master local --class ru.lev.pyryanov.App --packages com.databricks:spark-xml_2.12:0.13.0,org.postgresql:postgresql:42.5.1 /opt/workspace/DE_final_project_jar/DE-final-project.jar
