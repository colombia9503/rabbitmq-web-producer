package com.accenture.camel.model;

import java.util.HashMap;

public class MessageSource {
	private String route;
	private HashMap<String, Object> payload;

	public MessageSource(String route) {
		this.payload = new HashMap<>();
		this.route = route;
	}
	
	public MessageSource() {
		// TODO Auto-generated constructor stub
	}

	public HashMap<String, Object> getPayload() {
		return payload;
	}

	public void setPayload(HashMap<String, Object> payload) {
		this.payload = payload;
	}



	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public <T extends Object> MessageSource addPayload(String key, T obj) {
		payload.put(key, obj);
		return this;
	}
}
