package com.ecommerce.app.entity;

import java.util.List;

public class Cart {

	private Integer id;
	private Integer userId;
	//Ver que pedo con la inicialización
	private List<Product> products;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	
}
