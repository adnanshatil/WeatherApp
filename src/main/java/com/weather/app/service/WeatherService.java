package com.weather.app.service;

import com.weather.app.component.City;
import com.weather.app.component.Temperature;

import java.util.List;

public interface WeatherService {

    String callWeatherApi(final String city);

    void analyseWeatherForecast(final String weatherData);

    List<City> availableCities();

    List<Temperature> convertJsonToTemperature(final String json);
}
