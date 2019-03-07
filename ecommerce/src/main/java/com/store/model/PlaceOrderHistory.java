package com.store.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class PlaceOrderHistory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int historyId;
	@ManyToOne
	private Product product;
	@ManyToOne
	private User user;
	private int quantity;
	private double totalPrice;
	private Date placedOnDate;
	public int getHistoryId() {
		return historyId;
	}
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getPlacedOnDate() {
		return placedOnDate;
	}
	public void setPlacedOnDate(Date placedOnDate) {
		this.placedOnDate = placedOnDate;
	}

}
