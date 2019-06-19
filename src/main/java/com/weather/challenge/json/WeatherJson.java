
package com.weather.challenge.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherJson  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected static final String TEMP = "temp";
	protected static final String TEMPMIN = "temp_min";
	protected static final String TEMPMAX = "temp_max";
	protected static final String WIND = "wind";
	protected static final String WIND_SPEED = "speed";
	protected static final String WIND_DEG = "deg";	
	protected static final String HUMIDITY = "humidity";
	protected static final String WEATHER = "weather"; 
	protected static final String MAIN = "main";
	protected static final String SYS = "sys";
	protected static final String SUNRISE = "sunrise";
	protected static final String SUNSET = "sunset";
	protected static final String COUNTRY = "country";
	protected static final String DESC = "description";
	protected static final String ICON = "icon";
	protected static final String NAME = "name";
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Coord getCoord() {
		return coord;
	}
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public Integer getDt() {
		return dt;
	}
	public void setDt(Integer dt) {
		this.dt = dt;
	}
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	public Map<String, Object> getExtra() {
		return extra;
	}
	public void setExtra(Map<String, Object> extra) {
		this.extra = extra;
	}
	private Integer id;
    private String name;	
    private Coord coord;
    private Sys sys;
    private String base;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private Integer dt;
    private Integer cod;
    
    private List<Weather> weather = new ArrayList<Weather>();
    private Map<String, Object> extra = new HashMap<String, Object>();



}
