package com.weather.app.component;

import java.util.List;

public class DailyForecasts {

    private List<DailyForecast> dailyForecasts;

    public DailyForecasts() {

    }

    public DailyForecasts(List<DailyForecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }

    public List<DailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }

    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }
}
