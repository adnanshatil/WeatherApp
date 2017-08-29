package com.weather.app.job;

import com.weather.app.service.impl.DefaultCustomLoggerService;
import com.weather.app.service.impl.DefaultWeatherService;
import com.weather.app.util.AppUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class ScheduledJob {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DefaultWeatherService defaultWeatherService;

    @Autowired
    DefaultCustomLoggerService defaultCustomLoggerService;

    @Scheduled(cron = "${pulling.frequency}")
    public void execute() {
        LOG.info("starting scheduled job @ " + AppUtility.getCrrentDateAndTime());

        final List<String> cities = defaultWeatherService.availableCities();

        defaultCustomLoggerService.writeToCustomLog("Found cities: " + cities.size());

        for(final String city: cities) {
            defaultCustomLoggerService.writeToCustomLog("Fetching data for city: " + city);

            final String weatherForecastData = defaultWeatherService.callWeatherApi(city);

            if(!StringUtils.isEmpty(weatherForecastData)) {
                // defaultCustomLoggerService.writeToCustomLog("Received data for " + city + ": " + weatherForecastData);

                if(defaultWeatherService.analyseWeatherForecast(weatherForecastData)) {
                    continue;
                }
            }
        }

        LOG.info("ending scheduled job @ " + AppUtility.getCrrentDateAndTime());
    }
}
