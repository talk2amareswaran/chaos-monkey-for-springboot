package com.talk2amareswaran.projects.productservice.model;

public class Product {

	private long id;
	private String productName;
	private String productSKU;
	private double price;
	private long availableQty;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSKU() {
		return productSKU;
	}

	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(long availableQty) {
		this.availableQty = availableQty;
	}

}
