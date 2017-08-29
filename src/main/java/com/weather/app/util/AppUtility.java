package com.weather.app.util;

import com.weather.app.constant.Constant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppUtility {

    public static String getCrrentDateAndTime() {

        final DateFormat dateFormat = new SimpleDateFormat(Constant.DATE_FORMAT);
        final Date date = new Date();

        return dateFormat.format(date);
    }
}
