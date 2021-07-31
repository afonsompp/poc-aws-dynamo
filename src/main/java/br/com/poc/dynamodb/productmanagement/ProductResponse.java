package br.com.poc.dynamodb.productmanagement;

import java.math.BigDecimal;

public class ProductResponse {

	private String id;
	private String name;
	private String description;
	private Integer stock;
	private BigDecimal price;

	@Deprecated
	public ProductResponse() {}

	public ProductResponse(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.stock = product.getStock();
		this.price = product.getPrice();
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public Integer getStock() {
		return this.stock;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

}
