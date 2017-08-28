package com.weather.app.service.impl;

import com.weather.app.integration.WeatherApiInterface;
import com.weather.app.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultWeatherService implements WeatherService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WeatherApiInterface weatherApiInterface;

    @Override
    public String showLogFile() {
        return null;
    }

    @Override
    public void callWeatherAPI() {
        LOG.info("DefaultWeatherService::callWeatherAPI is called");
        weatherApiInterface.callWeatherApi();
    }
}
