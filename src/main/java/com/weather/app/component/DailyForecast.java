package com.weather.app.component;

public class DailyForecast {
    private String Date;
    private Minimum Minimum;
    private Maximum Maximum;

    public DailyForecast() {

    }

    public DailyForecast(String Date, com.weather.app.component.Minimum Minimum, com.weather.app.component.Maximum Maximum) {
        this.Date = Date;
        this.Minimum = Minimum;
        this.Maximum = Maximum;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public com.weather.app.component.Minimum getMinimum() {
        return Minimum;
    }

    public void setMinimum(com.weather.app.component.Minimum Minimum) {
        this.Minimum = Minimum;
    }

    public com.weather.app.component.Maximum getMaximum() {
        return Maximum;
    }

    public void setMaximum(com.weather.app.component.Maximum Maximum) {
        this.Maximum = Maximum;
    }
}
