package com.challenge.productAPI.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Taxes {
	
	private Integer clientId;
	private String type;
	private Integer percentage;
	
	public Taxes() {}
	
	public Taxes(Integer clientId, String type, Integer percentage) {
		super();
		this.clientId = clientId;
		this.type = type;
		this.percentage = percentage;
	}

	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
}
