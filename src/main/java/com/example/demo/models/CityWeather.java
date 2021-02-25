package com.example.demo.models;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CityWeather {
    public WeatherData weatherData;

    public String getWeather(String cityName) throws IOException {
        URL weatherUrl= new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=2135c3f7f652abb768bf5a7fd30d743c");
        BufferedReader inputFromWeatherUrl = new BufferedReader(new InputStreamReader(weatherUrl.openStream()));
        this.weatherData = new Gson().fromJson(inputFromWeatherUrl, WeatherData.class);

        return "warm";
    }
}
