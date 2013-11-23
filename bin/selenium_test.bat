@echo off
rem ********************************
rem This batfile runs Selenium tests uses failsafe plugin
rem *******************************

call mvn test-compile failsafe:integration-test

