package com.weather.challenge.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.weather.challenge.json.WeatherJson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource("classpath:config.properties")
@Service
public class WeatherServiceImpl implements IWeatherService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
		
	@Autowired
	private Environment env;

	@Override
	public WeatherJson getWeatherFromEndPoint(String place) {
	    
		log.info(place);
		log.info(env.getProperty("openweather.api.url"));
		log.info(env.getProperty("openweather.api.appid"));
		final String uri = 
	    		env.getProperty("openweather.api.url")
	    		.concat("?q=")
	    		.concat(place).concat("&appid=")
	    		.concat(env.getProperty("openweather.api.appid"))
	    		.concat("&units=imperial");     
	    RestTemplate restTemplate = new RestTemplate();
	    return restTemplate.getForObject(uri, WeatherJson.class);
	    
	}
	
}
