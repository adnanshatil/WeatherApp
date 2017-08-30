package com.weather.app.constant;

public class Constant {
    public final static String MENU = "";
    public final static String EMPTY_STRING = "";
    public final static String CITY_DELIMITER = "|";
    public final static String CITY_KEY_VALUE_DELIMITER = ",";
    public final static String DATE_FORMAT = "dd/MM/yy HH:mm:ss";
    public final static String LINE_BREAK = "<br>";

    public final static String CITY_PARAM = "{CITY}";
    public final static String API_KEY_PARAM = "{API_KEY}";
    public final static String API_URI = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + CITY_PARAM + "?apikey=" + API_KEY_PARAM;

    public final static String JSON_KEY_DAILY_FORECAST = "DailyForecasts";
    public final static String JSON_KEY_DATE = "Date";
    public final static String JSON_KEY_TEMPERATURE = "Temperature";
    public final static String JSON_KEY_MINIMUM = "Minimum";
    public final static String JSON_KEY_MAXIMUM = "Maximum";
    public final static String JSON_KEY_VALUE = "Value";

    public final static String DATE_SPLITTER = "T";
}
