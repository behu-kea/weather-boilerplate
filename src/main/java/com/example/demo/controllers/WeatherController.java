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
    WeatherService weatherService = new WeatherService();

    @GetMapping("/assign-random-city")
    @ResponseBody
    // This method should save the randomly generated city in a session
    public String assignRandomCity(HttpServletRequest request) throws IOException {
        HttpSession httpSession = request.getSession();
        String randomCity = weatherService.getRandomCity();
        ArrayList<String> cities = (ArrayList<String>) httpSession.getAttribute("cities");

        if (cities == null) {
            cities = new ArrayList<>();
            // if notes object is not present in session, set notes in the request session
            httpSession.setAttribute("cities", cities);
        }

        cities.add(randomCity);

        WeatherData weatherData = CityWeather.getWeatherData("london", "API_KEY");
        // Getting the first item in the array
        HashMap<String, String> weather = weatherData.weather.get(0);

        String weatherDescription = weather.get("main");
        Float temperature = weatherData.main.get("temp");
        Float humidity = weatherData.main.get("humidity");

        return "Random city has been assigned";
    }

    @GetMapping("/get-random-cities")
    @ResponseBody
    // this method should get the random city generated above
    public ArrayList<String> getRandomCities(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();

        return (ArrayList<String>) httpSession.getAttribute("cities");
    }
}
