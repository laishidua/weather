# Getting Started

### Run in console:

>mvn install

after maven install go to the target folder where the .jar file is generated 

>java -jar weather-0.0.1-SNAPSHOT.jar

or simply run in console: mvn spring-boot:run

### View in Browser

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

### Corrections

1. Add Combo box: done in resources/templates/weather.html
2. Prefer GetMapping annotation: done in WeatherController.java methods
3. Keep all code in english: done
4. Follow Single Responsibility Pattern and change to switch: done in interface ILocalTimeService.java and its implementation.
5. OpenWeatherApi properties extracted from properties file: done in config.properties file
6. Handling errors like what happen if server return 500 error: done in IweatherService throws RestClientException, exceptions are handled in WeatherController class.
7. TDD approach: done with Junit tests.
8. Implement error handling: done.
9. Test code with sonar: done installing Eclipse/STS extension

Extra: Client messages are taken from messages.properties, using Mockito in class WeatherControllerTest for TDD test cases

