package com.weather.challenge.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.weather.challenge.service.ILocalTimeService;

@RunWith( SpringRunner.class )
public class LocalTimeServiceImplTest {
	
    @TestConfiguration
    static class LocalTimeServiceImplTestContextConfiguration {
  
        @Bean
        public ILocalTimeService localTimeService() {
            return new LocalTimeServiceImpl();
        }
    }	
	
	@Autowired
	private ILocalTimeService localTimeService;

	@Test
	public void testGetFormatedLocalTime() {
		
		SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
		format.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
		assertEquals(localTimeService.getFormatedLocalTime("Mexico City", new Date()), format.format(new Date()));
			
		format.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
		assertEquals(localTimeService.getFormatedLocalTime("Hong Kong", new Date()), format.format(new Date()));
		
		format.setTimeZone(TimeZone.getTimeZone("GMT+1:00"));
		assertEquals(localTimeService.getFormatedLocalTime("London", new Date()), format.format(new Date()));
		
	}

}
