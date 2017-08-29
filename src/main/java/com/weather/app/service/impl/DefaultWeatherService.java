package com.weather.app.service.impl;

import com.weather.app.constant.Constant;
import com.weather.app.integration.WeatherDataPuller;
import com.weather.app.log.CustomLogger;
import com.weather.app.service.WeatherService;
import com.weather.app.strategy.WeatherAppStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class DefaultWeatherService implements WeatherService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${available.cities}")
    private String availableCities;

    @Autowired
    WeatherDataPuller weatherDataPuller;

    @Autowired
    WeatherAppStrategy weatherAppStrategy;

    @Override
    public String callWeatherApi(String city) {
        return weatherDataPuller.callWeatherApi(city);
    }

    @Override
    public boolean analyseWeatherForecast(String weatherData) {
        return weatherAppStrategy.analyseWeatherData(weatherData);
    }

    @Override
    public List<String> availableCities() {
        List<String> cities = new ArrayList<String>();

        if(!StringUtils.isEmpty(availableCities)) {
            cities = Arrays.asList(availableCities.split(Constant.CITY_DELIMITER));
        }

        return !cities.isEmpty() ? cities : Collections.emptyList();
    }


}
