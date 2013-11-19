@echo off
call mvn clean compile package
set PORT=4567
start "Spark TicTacToe" java -jar target\TICTACTOE-1.0-SNAPSHOT-jar-with-dependencies.jar
