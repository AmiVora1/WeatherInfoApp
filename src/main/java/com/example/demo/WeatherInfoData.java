package com.example.demo;


public class WeatherInfoData {
    private String city;
    private double temp;
    private String date;
    private String unit;
    private String weather;

    // Getter and Setter for city
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    // Getter and Setter for temperature
    public double getTemp() {
        return temp;
    }
    public void setTemp(double temp) {
        this.temp = temp;
    }

    // Getter and Setter for date
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    // Getter and Setter for unit
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    // Getter and Setter for weather
    public String getWeather() {
        return weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
}
