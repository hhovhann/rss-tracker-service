#!/bin/sh
mvn clean package -DskipTests && java -jar ./target/rss-tracker-service-1.0.0-SNAPSHOT.jar
