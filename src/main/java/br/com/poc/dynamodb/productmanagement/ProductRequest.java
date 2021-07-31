package br.com.poc.dynamodb.productmanagement;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class ProductRequest {

	@NotBlank
	private String name;
	@NotBlank
	@Size(max = 500)
	private String description;
	@PositiveOrZero
	private Integer stock;
	@NotNull
	@Positive
	private BigDecimal price;

	@Deprecated
	public ProductRequest() {}

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

	public Product toProduct() {
		return new Product(name, description, stock, price);
	}

}
