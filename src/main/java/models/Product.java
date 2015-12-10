package models;

import java.math.BigDecimal;

public class Product {

	private long code;
	private String description;
	private BigDecimal price;
	private int quantity;

	// ------------------------
	// PUBLIC METHODS
	// ------------------------

	public Product() {
	}

	public Product(long code) {
		this.code = code;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product(long code, String description, BigDecimal price, int quantity) {
		this.code = code;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", description=" + description + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
}