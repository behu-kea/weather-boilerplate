package com.example.demo.models;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CityWeather {
    public static WeatherData getWeatherData(String cityName, String apiKey) throws IOException {
        // "http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=2135c3f7f652abb768bf5a7fd30d743c"
        URL weatherUrl= new URL("http://api.openweathermap.org/data/2.5/weather?units=metric&q=" + cityName + "&APPID=" + apiKey);
        BufferedReader inputFromWeatherUrl = new BufferedReader(new InputStreamReader(weatherUrl.openStream()));
        WeatherData weatherData = new Gson().fromJson(inputFromWeatherUrl, WeatherData.class);

        return weatherData;
    }
}
