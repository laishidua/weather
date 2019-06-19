package com.weather.challenge.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.challenge.json.WeatherJson;

@Service
public class WeatherServiceImpl implements IWeatherService {
	
	private static final String APPID= "012e3ddb7dc66828b72ea7dd32dbd5ea";

	@Override
	public WeatherJson getWeatherFromEndPoint(String place) {
	    final String uri = 
	    		"http://api.openweathermap.org/data/2.5/weather?q="
	    		.concat(place).concat("&appid=").concat(APPID).concat("&units=imperial");
	     
	    RestTemplate restTemplate = new RestTemplate();
	    WeatherJson result = restTemplate.getForObject(uri, WeatherJson.class);
	     
	    return result;
	    
	}
	
}
