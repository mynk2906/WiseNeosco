package com.wiseneosco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiseneosco.Model.WeatherData;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData,Integer>{

	WeatherData findByCity(String cityName);

}
