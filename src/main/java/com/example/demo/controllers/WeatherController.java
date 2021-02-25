package com.example.demo.controllers;

import com.example.demo.models.WeatherData;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


@Controller
public class WeatherController {
    public WeatherData weatherData;

    public WeatherController() throws IOException {
        URL weatherUrl= new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=2135c3f7f652abb768bf5a7fd30d743c");
        BufferedReader inputFromWeatherUrl = new BufferedReader(new InputStreamReader(weatherUrl.openStream()));
        this.weatherData = new Gson().fromJson(inputFromWeatherUrl, WeatherData.class);
    }

    @GetMapping("/")
    @ResponseBody
    public String renderAstronauts() throws IOException {
        // this.astronautsInSpaceData is what you will be working with!
        System.out.println(this.weatherData.coords);

        return "stuff";
    }
}
