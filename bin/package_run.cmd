@echo off
mvn clean compile package
set PORT=4567
java -jar target\TICTACTOE-1.0-SNAPSHOT-jar-with-dependencies.jar