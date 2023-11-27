package com.wiseneosco.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WeatherData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String city;
    private double temperatureInCelsius;
    private double chanceOfRain;
    private double windSpeed;
    private LocalDateTime timestamp;
    
    public WeatherData() {
		// TODO Auto-generated constructor stub
	}

	public WeatherData(Long id, String city, double temperatureInCelsius, double chanceOfRain, double windSpeed,
			LocalDateTime timestamp) {
		super();
		this.id = id;
		this.city = city;
		this.temperatureInCelsius = temperatureInCelsius;
		this.chanceOfRain = chanceOfRain;
		this.windSpeed = windSpeed;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getTemperatureInCelsius() {
		return temperatureInCelsius;
	}

	public void setTemperatureInCelsius(double temperatureInCelsius) {
		this.temperatureInCelsius = temperatureInCelsius;
	}

	public double getChanceOfRain() {
		return chanceOfRain;
	}

	public void setChanceOfRain(double chanceOfRain) {
		this.chanceOfRain = chanceOfRain;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "WeatherData [id=" + id + ", city=" + city + ", temperatureInCelsius=" + temperatureInCelsius
				+ ", chanceOfRain=" + chanceOfRain + ", windSpeed=" + windSpeed + ", timestamp=" + timestamp + "]";
	}
    
   
}
