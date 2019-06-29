package com.weather.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.weather.challenge.exception.BusinessException;
import com.weather.challenge.json.WeatherJson;
import com.weather.challenge.service.ILocalTimeService;
import com.weather.challenge.service.IWeatherService;
import com.weather.challenge.util.WeatherFormCollection;

@Controller
public class WeatherController {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private static final String FLASH_ERRORS = "errors";
	private static final String WEATHER_HTML = "weather";
	private static final String INDEX_REDIRECT = "redirect:/";

	@Autowired
	private IWeatherService weatherService;

	@Autowired
	private ILocalTimeService localTimeService;

	@Autowired
	private MessageSource messageSource;

	@GetMapping(value = { "/" })
	public String index(Model model) {
		model.addAllAttributes(new WeatherFormCollection().getWeather());
		return WEATHER_HTML;
	}

	@PostMapping(value = { "/weather" })
	public String consult(@RequestParam(name = "name", defaultValue = "") String name, Model model,
			RedirectAttributes flash) {
		if (name.isEmpty()) {
			flash.addFlashAttribute(FLASH_ERRORS, messageSource.getMessage("text.message.empty.name", null, null));
			return INDEX_REDIRECT;
		}
		String concatPlace = name.replace(" ", "+");
		try {
			WeatherJson weather = weatherService.getWeatherFromEndPoint(concatPlace);
			try {
				model.addAllAttributes(new WeatherFormCollection(weather, localTimeService, name).getWeather());
			} catch (BusinessException e) {
				log.error(e.getMessage());
				flash.addFlashAttribute(FLASH_ERRORS, messageSource.getMessage("text.error.code", null, null));
				return INDEX_REDIRECT;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			flash.addFlashAttribute(FLASH_ERRORS, messageSource.getMessage("text.unknownerror.data", null, null));
			return INDEX_REDIRECT;
		}

		return WEATHER_HTML;
	}

}
