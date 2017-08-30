package com.weather.app.strategy;

import com.weather.app.component.Temperature;
import com.weather.app.service.impl.DefaultCustomLoggerService;
import com.weather.app.service.impl.DefaultWeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherAppStrategy {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${threshold.temperature}")
    private Double thresholdTemperature;

    @Autowired
    DefaultCustomLoggerService defaultCustomLoggerService;

    @Autowired
    DefaultWeatherService defaultWeatherService;

    public void analyseWeatherData(final String weatherForecastData) {
        LOG.info("Started weather forecasting data for city");

        final List<Temperature> temperatureList = defaultWeatherService.convertJsonToTemperature(weatherForecastData);

        printWeatherReport(temperatureList);

        checkWeatherData(temperatureList);
    }

    private void printWeatherReport(final List<Temperature> temperatureList) {
        for(final Temperature temperature: temperatureList) {
            defaultCustomLoggerService.writeToCustomLog(    "Date: " + temperature.getForecastDate()
                                                            +   " Minimum: " + temperature.getMinimumTemperature()
                                                            +   " Maximum: " + temperature.getMaximumTemperature()
                );
        }
    }

    private void checkWeatherData(final List<Temperature> temperatureList) {
        boolean hasAlert = false;

        for(final Temperature temperature: temperatureList) {
            if( temperature.getMinimumTemperature() <= thresholdTemperature) {
                hasAlert = true;
                defaultCustomLoggerService.writeToCustomLog("Weather alert @ " + temperature.getForecastDate()
                                                                + " and forecasted temperature: " + temperature.getMinimumTemperature()
                    );
            }
        }

        if(!hasAlert) {
            defaultCustomLoggerService.writeToCustomLog("No alert found for this forecast");
        }
    }

}
