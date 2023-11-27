package com.wiseneosco.Service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiseneosco.Model.WeatherApiResponse;
import com.wiseneosco.Model.WeatherData;
import com.wiseneosco.Repository.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
    private WeatherRepository weatherRepository; // Inject WeatherRepository here

    @Autowired
    private OpenWeatherAPIService openWeatherAPIService; // Your OpenWeather API service

    // Method to fetch weather data for a specific city with caching
    public WeatherData getWeatherByCity(String cityName) {
    	WeatherData weatherData = weatherRepository.findByCity(cityName);

        if (weatherData != null && isDataFresh(weatherData)) {
            return weatherData;
        } else {
        	WeatherApiResponse data = openWeatherAPIService.fetchWeatherData(cityName);
        	WeatherData weatherData2= mapToCustomWeatherObject(data);
            weatherRepository.save(weatherData2);
            return weatherData2;
        }
    }

    private boolean isDataFresh(WeatherData weatherData) {
        Duration freshnessThreshold = Duration.ofMinutes(30);

        LocalDateTime dataTimestamp = weatherData.getTimestamp();

        Duration elapsedTime = Duration.between(dataTimestamp, LocalDateTime.now());

        return elapsedTime.compareTo(freshnessThreshold) <= 0;
    }

	public void updateWeatherDataForCities() {
		// TODO Auto-generated method stub
		
	}
	
	private WeatherData mapToCustomWeatherObject(WeatherApiResponse weatherApiResponse) {
        // Perform mapping from WeatherApiResponse to your Weather entity
        WeatherData weather = new WeatherData();
        weather.setCity(weatherApiResponse.getName());
        weather.setTemperatureInCelsius(convertToCelsius(weatherApiResponse.getMain().getTemp()));
        weather.setChanceOfRain(calculateChanceOfRain(weatherApiResponse));
        weather.setWindSpeed(weatherApiResponse.getWind().getSpeed());
        weather.setTimestamp(LocalDateTime.now());

        return weather;
    }

    private double convertToCelsius(double temperatureInKelvin) {
    	// Conversion from Kelvin to Celsius
    	double celsius = temperatureInKelvin - 273.15;
        
        // Using String.format to limit to two decimal places
        return Double.parseDouble(String.format("%.2f", celsius));
        
    }

    private double calculateChanceOfRain(WeatherApiResponse weatherApiResponse) {
    	if (weatherApiResponse.getClouds() != null && weatherApiResponse.getClouds().getAll() > 50) {
            return 70.0;
        }

        if (weatherApiResponse.getMain() != null && weatherApiResponse.getMain().getHumidity() > 70) {
            return 60.0;
        }

        return 0.0;
    }
}
