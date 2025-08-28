package com.example.demo;


public class WeatherInfoData {
    private String city;
    private String temp;
    private String date;
    private String unit;
    private String weather;
    private String responseCode;

    public WeatherInfoData()
    {

    }
    //Argument constructor
    public WeatherInfoData(String city, String temp, String date, String unit, String weather, String responseCode)
    {
        this.city=city;
        this.temp=temp;
        this.date=date;
        this.unit=unit;
        this.weather=weather;
        this.responseCode=responseCode;
    }
    // Getter and Setter for city
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    // Getter and Setter for temperature
    public String getTemp() {
        return temp;
    }
    public void setTemp(String temp) {
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
     // Getter and Setter for city
    public String getResponseCode() {
        return responseCode;
    }
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
