package com.weather.app.component;

public class Temperature {

    private String forecastDate;
    private Double minimumTemperature;
    private Double maximumTemperature;

    public Temperature() {

    }

    public Temperature(String forecastDate, Double minimumTemperature, Double maximumTemperature) {
        this.forecastDate = forecastDate;
        this.minimumTemperature = minimumTemperature;
        this.maximumTemperature = maximumTemperature;
    }

    public String getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(String forecastDate) {
        this.forecastDate = forecastDate;
    }

    public Double getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(Double minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public Double getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(Double maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }
}
