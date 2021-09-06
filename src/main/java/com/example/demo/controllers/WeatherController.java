package com.example.demo.controllers;

import com.example.demo.models.CityWeather;
import com.example.demo.models.WeatherData;
import com.example.demo.services.WeatherService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


@Controller
public class WeatherController {
    // Service to get a random city
    WeatherService weatherService = new WeatherService();

    @GetMapping("/assign-random-city")
    @ResponseBody
    // This method should save the randomly generated city in a session
    public String assignRandomCity() {

        System.out.println(1);
        String randomCity = weatherService.getRandomCity();
        System.out.println(randomCity);
        return "";
    }

    @GetMapping("/get-random-cities")
    @ResponseBody
    // this method should get the random city generated above
    public String getRandomCities() {
        return "";
    }
}
