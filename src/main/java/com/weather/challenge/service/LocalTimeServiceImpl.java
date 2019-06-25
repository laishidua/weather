package com.weather.challenge.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

/**
 * 
 * @author laish
 * LocalTimeServiceImpl implements Single Responsibility Pattern
 * The unique responsibility of this class is to get the formated local time
 * of a place.
 */
@Service
public class LocalTimeServiceImpl implements ILocalTimeService {

	@Override
	public String getFormatedLocalTime(String placeName, Date date) {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
		String utc = "";
		switch (placeName) {
			case "London": format.setTimeZone(TimeZone.getTimeZone("GMT+1:00"));
			break;
			case "Hong Kong": format.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
			break;	
			case "Mexico City": format.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
			break;
			default:
				format.setTimeZone(TimeZone.getTimeZone("UTC"));
				utc = " UTC";
			break;
		}
		return format.format(date).concat(utc);
	}

}
