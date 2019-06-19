package com.weather.challenge.controller;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.weather.challenge.json.WeatherJson;
import com.weather.challenge.service.IWeatherService;;

@Controller
public class WeatherController {
	
	@Autowired
	private IWeatherService weatherService;
	
	@RequestMapping(value= {"/"}, method=RequestMethod.GET)
	public String inicio(Model model) {
		WeatherJson weather= new WeatherJson();
		model.addAttribute("weather", weather);
		
		return "weather";
	}

	@RequestMapping(value= {"/weather"})
	public String consultar(@RequestParam(name="name", defaultValue="") String name, Model model, RedirectAttributes flash) {
		if (name.isEmpty()) {	
			flash.addFlashAttribute("errors", "Name of place must not be empty");
			return "redirect:/";
		} 
		String concatPlace = name.replace(" ", "+");
		WeatherJson weather = weatherService.getWeatherFromEndPoint(concatPlace);
		model.addAttribute("weather", weather);		
		java.util.Date time= new java.util.Date((long)weather.getDt()*1000);		
		model.addAttribute("time", time.toString());
		model.addAttribute("tempf", weather.getMain().getTemp());
		model.addAttribute("tempc", ((weather.getMain().getTemp() - 32)*5)/9);
		java.util.Date sunrise= new java.util.Date((long)weather.getSys().getSunrise()*1000);
		java.util.Date sunset= new java.util.Date((long)weather.getSys().getSunset()*1000);
		SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
		String utc = "";
		if (name.equals("London")) {
			format.setTimeZone(TimeZone.getTimeZone("GMT+1:00"));
		} else if (name.equals("Hong Kong")) {
			format.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));			
		} else if (name.equals("Mexico City")) {
			format.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));	
		} else {
			format.setTimeZone(TimeZone.getTimeZone("UTC"));
			utc = " UTC";
		}
		model.addAttribute("sunrise", format.format(sunrise).concat(utc));
		model.addAttribute("sunset", format.format(sunset).concat(utc));		
		return "weather";
	}
	
}
