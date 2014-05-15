simple-yarn-example
===================

mvn clean package

hdfs dfs -rm /apps/simple/simple-yarn-app-0.1.0.jar
hdfs dfs -copyFromLocal ~/Projects/trisberg/yarn-examples/simple-yarn-example/target/simple-yarn-app-0.1.0.jar /apps/simple/simple-yarn-app-0.1.0.jar


hadoop jar target/simple-yarn-app-0.1.0.jar com.springdeveloper.demo.Client 1

OR

mvn exec:java -Dexec.mainClass="com.springdeveloper.demo.Client" -Dexec.args="1"
