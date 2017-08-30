package com.weather.app.job;

import com.weather.app.component.City;
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

        final List<City> cities = defaultWeatherService.availableCities();

        defaultCustomLoggerService.writeToCustomLog("Weather service @ " + AppUtility.getCrrentDateAndTime());
        defaultCustomLoggerService.writeToCustomLog("Found cities: " + cities.size());

        for(final City city: cities) {
            defaultCustomLoggerService.writeToCustomLog("Fetching data for city: " + city.getCityName());

            final String weatherForecastData = defaultWeatherService.callWeatherApi(city.getCityKey());

            if(!StringUtils.isEmpty(weatherForecastData)) {
                defaultWeatherService.analyseWeatherForecast(weatherForecastData);
            }
        }

        defaultCustomLoggerService.writeToCustomLog("*** *** *** *** *** *** *** *** *** ***");
        LOG.info("ending scheduled job @ " + AppUtility.getCrrentDateAndTime());
    }
}
