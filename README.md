# grails-hibernate-filter

[![](https://jitpack.io/v/yvdlima/grails-hibernate-filter.svg)](https://jitpack.io/#yvdlima/grails-hibernate-filter)
[![Test Plugin](https://github.com/yvdlima/grails-hibernate-filter/actions/workflows/test-action.yml/badge.svg)](https://github.com/yvdlima/grails-hibernate-filter/actions/workflows/test-action.yml)

# Description

This is a fork of the already forked Grails 3.2 version [alexkramer/grails-hibernate-plugin](https://github.com/alexkramer/ZipCityState) 
for Grails 4 / GORM 7. The version 1.0 > Contains the Grails 4 code and 1.0 < the Grails 3.
The packaged can be found in jitpack: https://jitpack.io/#yvdlima/grails-hibernate-filter/1.0.0

This repo contains two projects:
  
1.  hibernate-filter-plugin - with plugin code
1.  hibernate-filter-example - with example application using plugin 

# Usage

## Build Plugin File

Clone the repository and execute in main directory command:

    ./gradlew hibernate-filter-plugin:jar
    
To publish a new version simply create a new release for it in GitHub, jitpack will build it automatically
    
## Running example application

To run example application use command:

    ./gradlew hibernate-filter-example:bootRun
    
## Installation

Add dependency in build.gradle:

    repositories {
        maven { url 'https://jitpack.io' }
    }
    
    dependencies {
        implementation 'com.github.yvdlima:grails-hibernate-filter:Tag'
    }

# Usage

Please refer to this project's [wiki](https://github.com/alexkramer/grails-hibernate-filter/wiki) for usage.
