package com.weather.app.strategy;

import com.weather.app.service.impl.DefaultCustomLoggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WeatherAppStrategy {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${threshold.temperature}")
    private String thresholdTemperature;

    @Autowired
    DefaultCustomLoggerService defaultCustomLoggerService;

    public boolean analyseWeatherData(final String weatherForecastData) {

        defaultCustomLoggerService.writeToCustomLog("Received data: " + weatherForecastData);

        parseWeatherData(weatherForecastData);

        return true;
    }

    private void parseWeatherData(final String data) {
        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = jsonParser.parseMap(data);
        List<Object> fiveDayForecart = (List<Object>) map.get("DailyForecasts");

        for(final Object dailyForecast: fiveDayForecart) {
            Map<String, Object> dailyWeatherData = (Map<String, Object>)dailyForecast;
            parseDailyData(dailyWeatherData);
        }
    }

    private void parseDailyData(final Map<String, Object> dailyData) {
        final String forecastDate = (String) dailyData.get("Date");
        final Map<String, Object> temperature = (Map<String, Object>)dailyData.get("Temperature");
        final Map<String, Object> minumum = (Map<String, Object>)temperature.get("Minimum");
        final Double minimumTemperature = (Double) minumum.get("Value");

        LOG.info("Date @ " + forecastDate + " - Minimum temperature: " + minimumTemperature);
    }

}
