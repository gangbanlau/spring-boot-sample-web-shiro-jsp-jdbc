package my.mycompany.myapp.domain;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class Product {

	/**
	 * Id
	 * product's primary key
	 */
	@NotNull
	private Long id;

	@NotNull
	@Size(min = 1)			// filter out "" 
	private String name;

	@NotNull
	private Double price;

	private String description;

	public void setId(Long i) {
		id = i;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Product[id=%d, name='%s', price=%f, description='%s']", id, name, price, description);		
	}
}