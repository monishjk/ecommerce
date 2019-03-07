package com.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentMode {
	@Id
	private String digi16;
	private String cvv;
	private double balance;	
	private int month;
	private int year;
	private String bankHolderName;
	public String getDigi16() {
		return digi16;
	}
	public void setDigi16(String digi16) {
		this.digi16 = digi16;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getBankHolderName() {
		return bankHolderName;
	}
	public void setBankHolderName(String bankHolderName) {
		this.bankHolderName = bankHolderName;
	}
	

}
