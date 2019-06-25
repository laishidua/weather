package com.weather.challenge.service;

import org.springframework.web.client.RestClientException;

import com.weather.challenge.json.WeatherJson;

public interface IWeatherService {

	public WeatherJson getWeatherFromEndPoint(String place) throws RestClientException;
	
}
