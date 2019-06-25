package com.weather.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.weather.challenge.json.WeatherJson;
import com.weather.challenge.service.ILocalTimeService;
import com.weather.challenge.service.IWeatherService;

@Controller
public class WeatherController {
	
	@Autowired
	private IWeatherService weatherService;
	
	@Autowired
	private ILocalTimeService localTimeService;	
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(value= {"/"})
	public String index(Model model) {
		WeatherJson weather= new WeatherJson();
		model.addAttribute("weather", weather);
		
		return "weather";
	}

	@PostMapping(value= {"/weather"})
	public String consult(@RequestParam(name="name", defaultValue="") String name, Model model, RedirectAttributes flash) {
		if (name.isEmpty()) {	
			flash.addFlashAttribute("errors", messageSource.getMessage("text.message.empty.name", null, null));
			return "redirect:/";
		} 
		String concatPlace = name.replace(" ", "+");		
		try {
			WeatherJson weather = weatherService.getWeatherFromEndPoint(concatPlace);
			model.addAttribute("weather", weather);		
			java.util.Date time= new java.util.Date((long)weather.getDt()*1000);		
			model.addAttribute("time", time.toString());
			model.addAttribute("tempf", weather.getMain().getTemp());
			model.addAttribute("tempc", ((weather.getMain().getTemp() - 32)*5)/9);
			java.util.Date sunrise= new java.util.Date((long)weather.getSys().getSunrise()*1000);
			java.util.Date sunset= new java.util.Date((long)weather.getSys().getSunset()*1000);
			model.addAttribute("sunrise", localTimeService.getFormatedLocalTime(name, sunrise));
			model.addAttribute("sunset", localTimeService.getFormatedLocalTime(name, sunset));	
		} catch (RestClientException ex) {
			if(ex instanceof HttpClientErrorException) {
				HttpClientErrorException clientEx = ((HttpClientErrorException)ex);
				flash.addFlashAttribute("errors", 
					messageSource.getMessage("text.error.code", null, null)
					.concat(" ").concat(clientEx.getStatusCode().toString()));
			} else {
				flash.addFlashAttribute("errors", 
						messageSource.getMessage("text.error.data", null, null));				
			}
			ex.printStackTrace();
			return "redirect:/";
		}		
		return "weather";
	}
	
}
