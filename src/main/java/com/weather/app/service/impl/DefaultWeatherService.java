package com.weather.app.service.impl;

import com.weather.app.component.City;
import com.weather.app.component.Temperature;
import com.weather.app.component.TemperatureParser;
import com.weather.app.constant.Constant;
import com.weather.app.integration.WeatherDataPuller;
import com.weather.app.service.WeatherService;
import com.weather.app.strategy.WeatherAppStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class DefaultWeatherService implements WeatherService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${available.cities}")
    private String availableCities;

    @Autowired
    WeatherDataPuller weatherDataPuller;

    @Autowired
    WeatherAppStrategy weatherAppStrategy;

    @Autowired
    TemperatureParser temperatureParser;

    @Override
    public String callWeatherApi(String city) {
        return weatherDataPuller.callWeatherApi(city);
    }

    @Override
    public void analyseWeatherForecast(String weatherData) {
        weatherAppStrategy.analyseWeatherData(weatherData);
    }

    @Override
    public List<City> availableCities() {
        List<City> cities = new ArrayList<City>();

        if(!StringUtils.isEmpty(availableCities)) {
            final String [] citiesKeyValue = availableCities.split(Pattern.quote(Constant.CITY_DELIMITER));

            for(final String cityKeyValue: citiesKeyValue) {
                final String [] arrCityKeyValue = cityKeyValue.split(Constant.CITY_KEY_VALUE_DELIMITER);

                final City city = new City();
                city.setCityName(arrCityKeyValue[0]);
                city.setCityKey(arrCityKeyValue[1]);

                cities.add(city);
            }
        }

        return !cities.isEmpty() ? cities : Collections.emptyList();
    }

    @Override
    public List<Temperature> convertJsonToTemperature(final String json) {
        return temperatureParser.parseJson(json);
    }

}
