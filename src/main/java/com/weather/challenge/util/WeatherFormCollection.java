package com.weather.challenge.util;

import java.util.HashMap;
import java.util.Map;
import com.weather.challenge.json.WeatherJson;
import com.weather.challenge.service.ILocalTimeService;

public class WeatherFormCollection {
	
	private Map<String, Object> collection = new HashMap<>();
	
	public WeatherFormCollection() {
		this.collection.put("weather", new WeatherJson());
	}
	
	public WeatherFormCollection(WeatherJson weather, ILocalTimeService localTimeService, String countryName) throws Exception {
		this.collection.put("weather", weather);		
		java.util.Date time= new java.util.Date((long)weather.getDt()*1000);		
		this.collection.put("time", time.toString());
		this.collection.put("tempf", weather.getMain().getTemp());
		this.collection.put("tempc", ((weather.getMain().getTemp() - 32)*5)/9);
		java.util.Date sunrise= new java.util.Date((long)weather.getSys().getSunrise()*1000);
		java.util.Date sunset= new java.util.Date((long)weather.getSys().getSunset()*1000);
		this.collection.put("sunrise", localTimeService.getFormatedLocalTime(countryName, sunrise));
		this.collection.put("sunset", localTimeService.getFormatedLocalTime(countryName, sunset));			
	}
	
	public Map<String, Object> getWeather() {
		return this.collection;
	}

}
