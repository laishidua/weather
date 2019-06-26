
package com.weather.challenge.json;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Clouds  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    private Integer all;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    public Clouds withAll(Integer all) {
        this.all = all;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Clouds withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
