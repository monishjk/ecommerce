package com.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotEmpty(message="product name cannot be blank")
	private String productname;
	@NotEmpty(message="Description is mandatory")
	private String description;
	@Min(value=0,message="Quantity cannot be less than 0")
	private int quantity;
	@Min(value=10,message="Minimum price must be must be 10")
	private double price;
	@ManyToOne
	private Category category;
	@Transient
	private MultipartFile image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	// System.out.println(product) ->toString() in Object class ->com.store.model.Product@39839
	//System.out.println(product) ->toString() in Product class ->
	//${product} ->toString()
	//${product.productname}} ->product.getProductName()
	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", description=" + description + ", quantity="
				+ quantity + ", price=" + price + ", category=" + category + ", image=" + image + "]";
	}
	
}
