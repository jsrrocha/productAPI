package com.challenge.productAPI.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	
	private Integer productId;
	private String name;
	private Double price;
	
	public Product() {}
	
	public Product(Integer productId, String name, Double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Map<String,Object> buildProductMap(Double taxes){
		Map<String,Object> productMap = new HashMap<String, Object>();
		productMap.put("productId",productId);
		productMap.put("name",name);
		productMap.put("price",price);
		productMap.put("taxes",taxes);
		return productMap;
	}
}
