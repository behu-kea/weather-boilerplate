package com.example.demo.services;

import java.util.ArrayList;
import java.util.Random;

public class WeatherService {
    public String getRandomCity() {
        ArrayList<String> cities = new ArrayList<String>();
        cities.add("London");
        cities.add("milano");
        cities.add("copenhagen");

        int randomIndex = new Random().nextInt(cities.size());
        String randomCity = cities.get(randomIndex);

        return randomCity;
    }
}
