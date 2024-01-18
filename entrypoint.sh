#!/bin/sh
set -e
rm -rf /app/target
mvn clean install -X
exec java -jar /app/target/example-api-0.0.1-SNAPSHOT.jar
