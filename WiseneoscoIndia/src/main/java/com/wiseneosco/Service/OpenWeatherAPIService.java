package com.wiseneosco.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wiseneosco.Model.WeatherApiResponse;

@Service
public class OpenWeatherAPIService {
	
	private String apiKey="e05f90eb24e4f5eb50961c46e5bdf502";
	
	// Method to fetch weather data for a given city from OpenWeather API
    public WeatherApiResponse fetchWeatherData(String cityName) {
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid="+apiKey;

        RestTemplate restTemplate = new RestTemplate();
        WeatherApiResponse weatherresponse = restTemplate.getForObject(apiUrl, WeatherApiResponse.class);
        return weatherresponse;
    }
}
