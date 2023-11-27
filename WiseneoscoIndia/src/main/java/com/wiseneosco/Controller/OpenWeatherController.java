package com.wiseneosco.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiseneosco.Model.WeatherData;
import com.wiseneosco.Service.WeatherService;

@CrossOrigin
@RestController
@RequestMapping("/weather")	
public class OpenWeatherController {
	
	@Autowired
    private WeatherService weatherService;

    @GetMapping("/city/{cityName}")
    public WeatherData getWeatherByCity(@PathVariable String cityName) {
        return weatherService.getWeatherByCity(cityName);
    }
}
