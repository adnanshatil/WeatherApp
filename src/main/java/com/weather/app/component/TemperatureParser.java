package com.weather.app.component;

import com.weather.app.constant.Constant;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class TemperatureParser {

    public List<Temperature> parseJson(final String json) {
        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        Map<String, Object> weatherForecastMap = jsonParser.parseMap(json);

        return !weatherForecastMap.isEmpty() ? fetchTemperatures(weatherForecastMap) : Collections.emptyList();
    }

    private List<Temperature> fetchTemperatures(final Map<String, Object> weatherForecastMap) {

        final List<Temperature> parsedTemperature = new ArrayList<Temperature>();
        final List<Object> fiveDayForecart = getFiveDayForecast(weatherForecastMap);

        if(fiveDayForecart.isEmpty())
            return Collections.emptyList();

        for(final Object dailyForecast: fiveDayForecart) {
            final Temperature temperature = populateTemperature(dailyForecast);
            parsedTemperature.add(temperature);
        }

        return !parsedTemperature.isEmpty() ? parsedTemperature : Collections.emptyList();
    }

    private Temperature populateTemperature(final Object dailyForecast) {
        final Temperature temperature = new Temperature();
        temperature.setForecastDate(getForecastDate(dailyForecast));
        temperature.setMaximumTemperature(getTemparature(dailyForecast, TemperatureEnum.MAXIMUM));
        temperature.setMinimumTemperature(getTemparature(dailyForecast, TemperatureEnum.MINIMUM));
        return temperature;
    }

    private List<Object> getFiveDayForecast(final Map<String, Object> weatherForecastMap) {
        return (List<Object>)weatherForecastMap.get(Constant.JSON_KEY_DAILY_FORECAST);
    }

    private String getForecastDate(final Object dailyForecast) {
        final Map<String, Object> dailyData = (Map<String, Object>) dailyForecast;
        final String forecastDate = (String) dailyData.get(Constant.JSON_KEY_DATE);

        if(!StringUtils.isEmpty(forecastDate)) {
            return forecastDate.split(Constant.DATE_SPLITTER)[0];
        }

        return Constant.EMPTY_STRING;
    }


    private Double getTemparature(final Object dailyForecast, TemperatureEnum option ) {
        final Map<String, Object> dailyData = (Map<String, Object>) dailyForecast;
        final Map<String, Object> temperature = (Map<String, Object>) dailyData.get(Constant.JSON_KEY_TEMPERATURE);
        Map<String, Object> temperatureObject = getTemperatureObject(temperature, option);

        return !temperature.isEmpty() ? (Double) temperatureObject.get(Constant.JSON_KEY_VALUE) : 0.0;
    }

    private Map<String, Object> getTemperatureObject(Map<String, Object> temperature, TemperatureEnum option) {

        Map<String, Object> temperatureObject = null;

        switch (option) {
            case MAXIMUM:
                temperatureObject = (Map<String, Object>)temperature.get(Constant.JSON_KEY_MAXIMUM);
                break;
            case MINIMUM:
                temperatureObject = (Map<String, Object>)temperature.get(Constant.JSON_KEY_MINIMUM);
                break;
            default:
                break;
        }

        return temperatureObject;
    }
}
