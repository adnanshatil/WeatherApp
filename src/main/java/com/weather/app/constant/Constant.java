package com.weather.app.constant;

import org.springframework.beans.factory.annotation.Value;

public class Constant {
    public final static String MENU = "";
    public final static String EMPTY_STRING = "";
    public final static String CITY_DELIMITER = ",";
    public final static String DATE_FORMAT = "dd/MM/yy HH:mm:ss";

    public final static String CITY_PARAM = "{CITY}";
    public final static String API_KEY_PARAM = "{API_KEY}";
    public final static String API_URI = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + CITY_PARAM + "?apikey=" + API_KEY_PARAM;
}
