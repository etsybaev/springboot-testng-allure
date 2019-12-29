# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.3.BUILD-SNAPSHOT/gradle-plugin/reference/html/)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)



# Installation.

To run tests rom IDE lombok plugin is needed:
1. Setup lombok plugin for your IDE,
2. Enable "Annotation processing" for your project in IDE.



 
#Test run:
To run the test execute this command:

> ./gradlew clean test AllureReport


#Test results:
The Allure report generator is used. Each report contains all requests\responses attached to a particular step.
Generated report for random.or tests also contains built charts attached for each test.

Report location: /build/reports/allure-report/index.html

#####Allure report is supposed to be run on some server. It uses some scripts that will not be run by your browser's security policy
from local pc.

Solutions are:
1. Open project in IntellijIdea, open html page and then open it in browser using Idea's quick launch icon in right-top corner  
2. Open console, navigate to project's dir and run this command:
> allure open build/reports/allure-report/
3. Upload the report to your web server
