TICTACTOE
=========
[![Build Status](https://travis-ci.org/SpaceStallions/TICTACTOE.png)](https://travis-ci.org/SpaceStallions/TICTACTOE) [![Coverage Status](https://coveralls.io/repos/SpaceStallions/TICTACTOE/badge.png)](https://coveralls.io/r/SpaceStallions/TICTACTOE)[![Selenium Test Status](https://saucelabs.com/browser-matrix/spacestallions.svg)](https://saucelabs.com/u/spacestallions)
=========

Assignment for T-303-HUGB 2013-3

# Run instructions

The web application is accessible at:
http://spacestallions.herokuapp.com/

## Install and run locally

Platform supported: Linux

Clone the repository:

`git clone https://github.com/SpaceStallions/TICTACTOE/ TTT`

To run the full batch of build tests and deploy locally:

`bin/build_and_test`

# Development manual

Development platforms supported:
* Windows
* Linux

This document describes how to build TICTACTOE from the source files.

## Windows

### 1. Setup required software

[Git](https://help.github.com/articles/set-up-git)
[Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[Maven](http://maven.apache.org/download.cgi)


### 2. Set environment variables

Create new variables or append the value if the variable already exists:

* Level: System, variable: `JAVA_HOME`, value: JDK install location
* Level: User, variable `M2_HOME`, value: Maven extract location
* Level: User, variable `M2`, value: `%M2_HOME%\bin`
* Level: User, variable `PATH`, value `%M2%`

### 3. Download the TICTACTOE source code
    
Use git-bash to clone the repository:

`git clone https://github.com/SpaceStallions/TICTACTOE/ TTT`

### 4. Resolve and install external libraries

These are needed by the build process:
	
	* spark			(tested on version 1.1.1)
	* junit      	(tested on version 4.8.1)
	* selenium		(tested on version 2.37.1)
		    
At this point all required software packages are present.

## Linux

### 1. Setup required software

```
sudo apt-get update 
sudo apt-get install git maven2 openjdk-7-jdk xvfb
```

### 2. Set environment variables

```
export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/
export PATH=/usr/lib/jvm/java-7-openjdk-amd64/bin:$PATH
```

### 3. Download the TICTACTOE source code
 
`git clone https://github.com/SpaceStallions/TICTACTOE/ TTT`

### 4. Resolve and install external libraries

In Linux, these dependencies will be automatically handled by Maven


TICTACTOE is now ready to be built.

------


# Compile and Package TICTACTOE

## Windows:

From the project directory run:

`bin\package`

## Linux:
From the project directory run:

	`bin/package`

The resulting binaries will be built in the "target" directory

## Commit to main branch / deploy to staging

To commit to the main branch, you must add the repo via git.

After the changes have been uploaded to the main github branch the following automated build process begins

1. Travis-CI will build the project, the status of the progress can be monitored at:
https://travis-ci.org/SpaceStallions/TICTACTOE
2. Travis-CI compiles the code and runs unit-tests, if successful Travis-CI will upload the application
to heroku staging server at http://spacestallions-staging.herokuapp.com/
3. Selenium is used for end-to-end testing on the staging application

## Deloy to production
1. When the staging environment is deemed to be ready for production, the build branch is merged with the
production build at github.
http://spacestallions.herokuapp.com/
2. Travis-CI will build the project, the status of the progress can be monitored at:
https://travis-ci.org/SpaceStallions/TICTACTOE
3. Travis-CI compiles the code and runs unit-tests, if successful Travis-CI will upload the application
to heroku production server at http://spacestallions.herokuapp.com/
