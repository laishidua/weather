package com.weather.challenge.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.weather.challenge.service.IWeatherService;

@TestPropertySource("classpath:config.properties")
@RunWith( SpringRunner.class )
public class WeatherServiceImplTest {

    @TestConfiguration
    static class WeatherServiceImplTestContextConfiguration {
  
        @Bean
        public IWeatherService weatherService() {
            return new WeatherServiceImpl();
        }
    }	
    
    @Autowired
	private IWeatherService weatherService;
	
	@Test
	public void testGetWeatherFromEndPoint() {
				
		assertEquals(weatherService.getWeatherFromEndPoint("London").getName(),"London");
		
	}

}
