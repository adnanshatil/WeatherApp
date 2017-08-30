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
 3. log directory with app.log in it. (log/app.log)

V. To run the program just execute below command from console and the spring boot server will run automatically

```
  $ java -jar app-0.0.1-SNAPSHOT.jar
```
VI. Maybe wait for 1 minutes once it is started and go to this link- [http://localhost:9090/getLog](http://localhost:9090/getLog)

### Background

I. This application is using [AccuWeather](https://developer.accuweather.com/accuweather-forecast-api/apis/get/forecasts/v1/daily/5day/%7BlocationKey%7D) Forecast API

II. **application.properties** is the file that contains all necessary properties. 
 - Server is running on 9090 port. But it can be changed with **server.port** parameter
 - **api.key** is the parameter contains AccuWeather API Key. As it is free account, it has limitations 60 calls / day
 - **available.cities** contains key,value pair for cities to get forecast data from Accuweather. This city key can be found from AccuWeather it self. But please be careful about the format -
 ```
 [CityName1],[CityKey1]|[CityName2],[CityKey2]|[CityName3],[CityKey3]
 ```
 - **threshold.temperature** is the threshold limit for weather alert in the log/app.log file
 - **pulling.frequency** is the parameter for frequency setup to call AccuWeather weather forecast service. Currently it is set to **0 \*/1 \* \* \* ?** which means it'll run every minutes
 
 III. Basically [http://localhost:9090/getLog](http://localhost:9090/getLog) reads the log/app.log file and show it to the browser
 
 IV. As this is a free API so it can call 60 times per day. After that authorization is failed from AccuWeather web service and in the system "Network Error" is logged
 
 V. The CronJob doesn't start immediately just after the service starts but it waits for 1 minutes to start. However there is some pre-populated data on **log/app.log** file. And this link will not cause any error - [http://localhost:9090/getLog](http://localhost:9090/getLog) 
