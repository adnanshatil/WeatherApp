package com.weather.app.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJob {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${pulling.frequency}")
    private String pullingFrequency;

    @Scheduled(cron = "${pulling.frequency}")
    public void execute() {
        LOG.info("got the value from prop file: " + pullingFrequency);
    }
}
