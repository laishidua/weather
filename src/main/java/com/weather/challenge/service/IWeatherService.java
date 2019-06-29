package com.weather.challenge.service;

import com.weather.challenge.exception.BusinessException;
import com.weather.challenge.json.WeatherJson;

public interface IWeatherService {
	
	public WeatherJson getWeatherFromEndPoint(String place) throws BusinessException;
			
}
