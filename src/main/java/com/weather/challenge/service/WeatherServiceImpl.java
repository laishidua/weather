package com.weather.challenge.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.weather.challenge.exception.BusinessException;
import com.weather.challenge.json.WeatherJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


@Service
@PropertySource("classpath:config.properties")
public class WeatherServiceImpl implements IWeatherService {
	
	public WeatherServiceImpl() {
		this.restTemplate = new RestTemplate();
	}
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Value("${openweather.api.url}")
	private String url;
	
		
	@Value("${openweather.api.appid}")
	private String appid;
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	private RestTemplate restTemplate;
	
	public RestTemplate getRestTemplate() {
		return this.restTemplate;
	}

	@Override
	public WeatherJson getWeatherFromEndPoint(String place) throws BusinessException{
		//WeatherJson
		log.debug(place);
		String uri = "";
		//TODO remove url for test cases. Read from properties file.
		if(url == null) {
			uri = "http://api.openweathermap.org/data/2.5/weather/data/2.5/weather?q=London&appid=012e3ddb7dc66828b72ea7dd32dbd5ea";
		} else {	
			uri = 
	    		new StringBuilder(url)
	    		.append("?q=")
	    		.append(place)
	    		.append("&appid=")
	    		.append(this.getAppid())
	    		.append("&units=imperial").toString(); 		
		}try {
		    return restTemplate.getForObject(uri, WeatherJson.class);			
		}catch (RestClientException e) {
			log.error(e.getMessage(),e);
			throw new BusinessException(e.getMessage());
		}
	}

	
}
