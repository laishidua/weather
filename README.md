# Getting Started

### To do

Download the project from https://github.com/laishidua/weather

Import the project as a maven project. 

Run the project as a Spring Boot App or run maven install to create the .jar file.

To run the jar file just execute in console:

>java -jar NAME-OF-GENERATED-JAR.jar

open a web browser in http://localhost:8080/

As the instructions are from 2016, if you want to use old maven versions or libraries,
 change the versions in the pom.xml file.
 
The file Readme.pdf shows the production site.

### How it was made

It is a coupled MVC with service oriented architecture project where the view is made in Thymeleaf, all tamplates are in directory templates.

Packages:

com.weather.challenge.controller

Controller of the project, get the request from the client form and use the package service to get the parsed object.

com.weather.challenge.service

Interface to get the json from the endpoint and parsing it to convert it to Java Object defined in json package.

The implementation of the Interface use RestTemplate to parse the json Object also
in this class WeatherServiceImpl change the Api key for open weather called APPID with your own.

com.weather.challenge.json

All the POJO classes needed to parse the json Object.


