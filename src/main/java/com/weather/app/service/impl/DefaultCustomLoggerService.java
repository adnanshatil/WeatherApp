package com.weather.app.service.impl;

import com.weather.app.log.CustomLogger;
import com.weather.app.service.CustomLoggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCustomLoggerService implements CustomLoggerService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CustomLogger customLogger;

    @Override
    public void writeToCustomLog(String line) {
        customLogger.writeToLog(line);
    }

    @Override
    public String readFromCustomLog() {
        return customLogger.readFromLog();
    }
}
