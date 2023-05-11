package com.shopping.productservice.dto;

public class ProductRequest {
	private String name;
	private long price;
	private long quantity;

	public ProductRequest() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("name=" + name).append(",price=" + price).append(",quantity=" + quantity);
		return builder.toString();
	}
}
