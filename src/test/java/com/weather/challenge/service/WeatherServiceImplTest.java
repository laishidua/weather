package com.weather.challenge.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.weather.challenge.exception.BusinessException;
import com.weather.challenge.json.WeatherJson;

@RunWith(SpringRunner.class)
@SpringBootTest
@PropertySource("classpath:config.properties")
public class WeatherServiceImplTest {
	
	private static final String URL = "http://api.openweathermap.org/data/2.5/weather/data/2.5/weather?q=London&appid=012e3ddb7dc66828b72ea7dd32dbd5ea";
		
	@InjectMocks
	WeatherServiceImpl weatherService;
	
	@Mock 
	RestTemplate restTemplate;
		
	@Test
	public void testGetWeatherFromEndPoint() throws Exception {
		Mockito.when(restTemplate.getForObject(URL, WeatherJson.class))
		.thenReturn(getValidWeatherJson());		
		WeatherJson response = weatherService.getWeatherFromEndPoint("London");
		assertNotNull(response);
		assertEquals("London", response.getName());
	}	

	 @Test(expected = BusinessException.class)
	public void testGetWeatherFromEndPointThrowBsinessException() throws Exception {
		Mockito.when(restTemplate.getForObject(URL, WeatherJson.class))
		.thenThrow(new RestClientException("Invalid Request"));		
		WeatherJson response = weatherService.getWeatherFromEndPoint("London");
		assertNotNull(response);
		assertEquals("London", response.getName());
	}	
	
	private WeatherJson getValidWeatherJson(){
		WeatherJson weatherJson = new WeatherJson();
		weatherJson.setName("London");
		return weatherJson;
	}

		
	
}
