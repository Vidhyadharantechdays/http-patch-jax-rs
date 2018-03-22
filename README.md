# Person API 
[![Build Status](https://travis-ci.org/vidhya03/http-patch-jax-rs.svg?branch=master)](https://travis-ci.org/vidhya03/http-patch-jax-rs) [![codecov](https://codecov.io/gh/vidhya03/http-patch-jax-rs/branch/master/graph/badge.svg)](https://codecov.io/gh/vidhya03/http-patch-jax-rs) [![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://github.com/vidhya03/http-patch-jax-rs/blob/master/LICENSE.md) [![HitCount](http://hits.dwyl.io/vidhya03/http-patch-jax-rs.svg)](http://hits.dwyl.io/vidhya03/http-patch-jax-rs)  [![GitHub issues](https://img.shields.io/github/issues/vidhya03/http-patch-jax-rs.svg)](https://github.com/vidhya03/http-patch-jax-rs/issues) [![](https://img.shields.io/github/issues/vidhya03/http-patch-jax-rs/help%20wanted.svg?colorB=&colorA=5319e7)](https://github.com/vidhya03/http-patch-jax-rs/labels/help%20wanted)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](https://egghead.io/courses/how-to-contribute-to-an-open-source-project-on-github)

A simple HTTP REST service  web application also called as Person API

# Heads up
- This project has been hosted in Openshift
- Access this project @ http://http-patch-vidhya.1d35.starter-us-east-1.openshiftapps.com/
- Swagger for this API [http-patch-demo-swagger.json](src/main/resources/http-patch-demo-swagger.json)
- [Deeplink](https://raw.githubusercontent.com/vidhya03/http-patch-jax-rs/master/src/main/resources/http-patch-demo-swagger.json) for direct import
- Try this Person API at [http://try.personapi.labkit.in/](https://vidhya03.github.io/swagger-editor/)

# Development
- checkout
 ```  
   git clone https://github.com/vidhya03/http-patch-jax-rs.git
```
- compile
```
  cd  http-patch-jax-rs.git
  mvn compile
```
- Spotbugs 
 [SpotBugs](https://spotbugs.github.io/) is a program which uses static analysis to look for bugs in Java code.

  Spotbugs can be triggred via compile time.
```
  mvn -Pspotbugs compile
``` 

  Spotbugs can also be check by using the below command.
```
  mvn -Pspotbugs spotbugs:check
```

  `Debug` the spotbugs error via the following command.
```
  mvn -Pspotbugs spotbugs:gui
```  
  The above command will popup spotbugs errors in GUI like this
  ![spotbugs error view in GUI](src/test/resources/spotbugs-viewer-gui.png)
  
 
# Rest API testing using karate
- To run test against production
```
  mvn test
```
- To run test against local deployment
```
  mvn test -Dkarate.env=dev
```
and the HTML reports would be output to /target/surefire-reports/TEST-com.labkit.test.personapi.PersonApi.html 
![karate test Report](src/test/resources/karate-rest-api-test-reports.png) 
# Code Coverage using Cobertura
- To run test and perform code coverage
```
  mvn cobertura:cobertura
```
and the HTML reports would be output to target/site/cobertura/index.html
![Cobertura Code Coverage Report](src/test/resources/cobertura-html-reports.png) 
# Code Coverage using Jacoco
- To run test and perform code coverage
```
  mvn clean test -Pcoverage
```
and the HTML reports would be output to target/site/jacoco/index.html
![Jacoco Code Coverage Report](src/test/resources/jacoco-html-reports.png) 

# License
* [MIT License](https://github.com/vidhya03/http-patch-jax-rs/blob/master/LICENSE.md)

# Credits
- [@vidhya03](https://github.com/vidhya03) : The Enthusiastic



