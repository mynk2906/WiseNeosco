package com.wiseneosco.Model;

import java.util.List;

public class WeatherApiResponse {
    private Coord coord;
    private List<Weather> weather;
    private Main main;
    private Clouds clouds;
    private Wind wind;
    private String name;
    // Other attributes and their getters/setters as per JSON response
    
    public WeatherApiResponse() {
		// TODO Auto-generated constructor stub
	}
   
	public WeatherApiResponse(Coord coord, List<Weather> weather, Main main, Clouds clouds, Wind wind, String name) {
		super();
		this.coord = coord;
		this.weather = weather;
		this.main = main;
		this.clouds = clouds;
		this.wind = wind;
		this.name = name;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds cloud) {
		this.clouds = cloud;
	}
	
	
}
