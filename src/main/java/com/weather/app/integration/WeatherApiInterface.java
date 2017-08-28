package com.weather.app.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.app.component.DailyForecast;
import com.weather.app.component.DailyForecasts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WeatherApiInterface {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    public final static String URI = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/133328?apikey=roAkw1pqfJtBGOgq1UP3exdJj7mfX4wy";

    public void callWeatherApi() {

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(URI, String.class);

        LOG.info(result);

        /*
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<DailyForecast> dailyForecasts = Arrays.asList(objectMapper.readValue(result, DailyForecast[].class));

            for (DailyForecast dailyForecast:dailyForecasts) {
                LOG.info(dailyForecast.getDate());
            }

        } catch (Exception exp) {
            LOG.error(exp.getMessage());
        }
        */

    }

}
