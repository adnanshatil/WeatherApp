package com.weather.app.service;

public interface CustomLoggerService {

    void writeToCustomLog(final String line);

    String readFromCustomLog();

}
