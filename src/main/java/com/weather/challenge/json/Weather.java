
package com.weather.challenge.json;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Weather  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    private Integer id;
    private String main;
    private String icon;
    private String description;
    private Map<String, Object> extra = new HashMap<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Weather withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public Weather withMain(String main) {
        this.main = main;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Weather withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Weather withIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Map<String, Object> getExtra() {
        return this.extra;
    }

    public void setExtra(String name, Object value) {
        this.extra.put(name, value);
    }

}
