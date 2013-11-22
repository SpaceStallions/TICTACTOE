TICTACTOE
=========

[![Build Status](https://travis-ci.org/SpaceStallions/TICTACTOE.png)](https://travis-ci.org/SpaceStallions/TICTACTOE) [![Coverage Status](https://coveralls.io/repos/SpaceStallions/TICTACTOE/badge.png)](https://coveralls.io/r/SpaceStallions/TICTACTOE)
=======


Assignment for T-303-HUGB 2013-3

# Master build instructions
//bæta við lýsingu travis og heroku hér

# Local build instructions

Development platforms supported:
* Windows
* Linux

This document describes how to build TICTACTOE from the source files.
First all required software has to be installed:

## 1. Download and install the Java JDK

Note: the JRE is not enough.
* In order to build TICTACTOE, you need to have JAVA 1.7 (Earlier versions might work OK, but are not tested.)


## 2. Download and extract Maven

### Windows

See http://maven.apache.org/download.html

### Linux

    sudo apt-get install maven3
	
## 3. Set environment variables

### Windows

Create new variables or append the value if the variable already exists:

* Level: System, variable: `JAVA_HOME`, value: JDK install location
* Level: User, variable `M2_HOME`, value: Maven extract location
* Level: User, variable `M2`, value: `%M2_HOME%\bin`
* Level: User, variable `PATH`, value `%M2%`

### Linux

Nothing to do.


## 4. Download the TICTACTOE source code
    
	https://github.com/SpaceStallions/TICTACTOE/

## 5. Resolve and install external libraries

These are needed by the build process:
	
	* spark-core	(v. 1.1.1)
	* junit      	(v. 4.8.1)
	
    
At this point all required software packages are present.
TICTACTOE is now ready to be built.


## 8. Compile the TICTACTOE

    mvn package

The resulting binaries will be built in the "target" directory:

* Windows: //hvaða slóð?
* Linux:   //hvaða slóð?

