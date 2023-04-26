# Getting Started

### Softwares needed to run the application locally 
* Java : install the Oracle JDK 17, see https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
* gradle: install Gradle 8.1.1, see https://gradle.org/install/
* PostgreSQL: install PostgreSQL 15.2
* git: you should already have it installed on your laptop :-)

### Database setup
* The application is expecting a to access a database named: testdb on localhost, username: postgres and password: admin
* If you created your local database with other settings you will just need to udpate the content of file src/main/resources/application.properties.
  - spring.datasource.url= jdbc:postgresql://localhost:5432/testdb
  - spring.datasource.username= postgres
  - spring.datasource.password= admin

### Build
From the repository directory run the command
  - windows: gradlew bootJar
  - linux: ./gradlew bootJar


### Run
From the repository directory run the command
  - windows: java -jar build\libs\clouddemo-0.0.1-SNAPSHOT.jar
  - linux: java -jar build/libs/clouddemo-0.0.1-SNAPSHOT.jar

### Access and usage
  - Check the application is running by accessing http://localhost:8080/messagestatic from your browser
  - Create your first message with Postman:
    - Create a POST request to http://localhost:8080/messages 
    - with body type raw and JSON
    - with body content: {"content" : "Mon premier message"}
  - You can now check that 
    - Accessing http://localhost:8080/messages/ or http://localhost:8080/messages/{id} 
	from your browser enables you to display your messages
