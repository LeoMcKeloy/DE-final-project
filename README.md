### Подключиться к контейнеру spark-master
>docker exec -it spark-master bash

### Загрузить джарник в контейнер spark-master
>docker cp DE-final-project.jar spark-master:/

### Запуск джарника в spark-master контейнере
>$SPARK_HOME/bin/spark-submit --master local --class ru.lev.pyryanov.App --packages com.databricks:spark-xml_2.12:0.13.0,org.postgresql:postgresql:42.5.1 DE-final-project.jar
