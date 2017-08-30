# WeatherApp (built-on Spring Boot)

### Pre-requisite
Before doing anything please make sure that you have below things already in place (this instructions are solely for MacOSX)- 

I. JAVA 8

II. %JAVA_HOME% property is properly set in your environment so that **java -jar** command knows which java version to consider

III. **Maven** is needed if you want to try this app with your IDE and further you need to make package

### Steps
I. click on the target link and WeatherApplication.zip will be found there

II. Download the WeatherApplication.zip file [Caution: size 12.3 MB]

III. Unzip WeatherApplication.zip file

IV. In the WeatherApplication folder 3 things can be found. 
 1. app-0.0.1-SNAPSHOT.jar, 
 2. application.properties and 
 3. log directory with app.log in it.

V. To run the program just execute below command from console and the spring boot server will run automatically

```
  $ java -jar app-0.0.1-SNAPSHOT.jar
```
VI. Maybe wait for 1 minutes once it is started and go to this link- [http://localhost:9090/getLog](http://localhost:9090/getLog)

### Notes

I. This application is using [AccuWeather](https://developer.accuweather.com/accuweather-forecast-api/apis/get/forecasts/v1/daily/5day/%7BlocationKey%7D) Forecast API

II. **application.properties** is the file that contains all necessary properties. 
 - Server is running on 9090 port. **api.key**
 - **api.key** 
