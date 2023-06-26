# grails-hibernate-filter
[comment]: <> ([![]&#40;https://jitpack.io/v/yvdlima/grails-hibernate-filter.svg&#41;]&#40;https://jitpack.io/#yvdlima/grails-hibernate-filter&#41;)
[comment]: <> ([![Test Plugin]&#40;https://github.com/yvdlima/grails-hibernate-filter/actions/workflows/test-action.yml/badge.svg&#41;]&#40;https://github.com/yvdlima/grails-hibernate-filter/actions/workflows/test-action.yml&#41;)
# Description

This is a Grails 5 fork of the Grails 4 fork by [yvdlima/grails-hibernate-filter](https://github.com/yvdlima/grails-hibernate-filter), which was forked from the Grails 3.2 version by [alexkramer/grails-hibernate-plugin](https://github.com/alexkramer/grails-hibernate-filter). 

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
        implementation 'com.github.smcintosh-icf:grails-hibernate-filter:Tag'
    }

# Usage

Please refer to the original project's [wiki](https://github.com/alexkramer/grails-hibernate-filter/wiki) for usage.
