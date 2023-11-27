package com.wiseneosco.Schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wiseneosco.Service.WeatherService;

@Component
public class WeatherDataUpdater {
	
	@Autowired
    private WeatherService weatherService; // Inject your WeatherService here

    @Scheduled(fixedDelay = 3600000) // Run every 1 hour (adjust interval as needed)
    public void updateWeatherData() {
        weatherService.updateWeatherDataForCities();
        // This method will be executed at regular intervals defined by the fixedDelay (in milliseconds)
    }
}
