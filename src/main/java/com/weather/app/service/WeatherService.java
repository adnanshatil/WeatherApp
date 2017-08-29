package com.weather.app.service;

import java.util.List;

public interface WeatherService {

    String callWeatherApi(final String city);

    boolean analyseWeatherForecast(final String weatherData);

    List<String> availableCities();
}
