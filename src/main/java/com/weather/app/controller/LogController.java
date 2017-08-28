package com.weather.app.controller;

import com.weather.app.constant.Constant;
import com.weather.app.service.impl.DefaultWeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class LogController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DefaultWeatherService defaultWeatherService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String returnMenu() {
        return Constant.MENU;
    }

    @RequestMapping(value = "/getLog", method = RequestMethod.GET)
    @ResponseBody
    public String returnLog() {
        LOG.info("hello world");
        defaultWeatherService.callWeatherAPI();
        return "HELLO WORLD";
    }
}
