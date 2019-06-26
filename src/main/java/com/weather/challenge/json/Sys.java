
package com.weather.challenge.json;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Sys  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    private Double message;
    private String country;
    private Long sunrise;
    private Long sunset;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Sys withMessage(Double message) {
        this.message = message;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Sys withCountry(String country) {
        this.country = country;
        return this;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Sys withSunrise(Long sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public Sys withSunset(Long sunset) {
        this.sunset = sunset;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Sys withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
