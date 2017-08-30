package com.weather.app.component;

public class City {

    private String cityName;
    private String cityKey;

    public City () {

    }

    public City(String cityName, String cityKey) {
        this.cityName = cityName;
        this.cityKey = cityKey;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityKey() {
        return cityKey;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }
}
