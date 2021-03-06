package com.weather.app.integration;

import com.weather.app.constant.Constant;
import com.weather.app.service.impl.DefaultCustomLoggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class WeatherDataPuller {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    DefaultCustomLoggerService defaultCustomLoggerService;

    public String callWeatherApi(final String city) {

        LOG.info("calling AccuWeather API");

        final String apiUriWithCityCode = Constant.API_URI.replace(Constant.CITY_PARAM, city).replace(Constant.API_KEY_PARAM, apiKey);

        String result = Constant.EMPTY_STRING;

        try {
            result = new RestTemplate().getForObject(apiUriWithCityCode, String.class);
            if(!StringUtils.isEmpty(result)) {
                defaultCustomLoggerService.writeToCustomLog("Network connectivity OK! Fetched data nicely");
            }
        } catch (Exception exp) {
            defaultCustomLoggerService.writeToCustomLog("Unable to connect to network");
        }

        LOG.info("API result" + result);

        return result;
    }

    /*
    public String callWeatherApi(final String city) {

        Path path = Paths.get("sample/Result.json");

        try {
            final List<String> fileLines = Files.readAllLines(path);

            if(!fileLines.isEmpty()) {
                return String.join(Constant.EMPTY_STRING, fileLines);
            }
        } catch(IOException exp) {
            LOG.error("Error reading from file: " + exp.getMessage());
        }

        return Constant.EMPTY_STRING;
    }
    */

}
