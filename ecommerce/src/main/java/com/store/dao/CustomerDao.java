package com.store.dao;

import com.store.model.Customer;
import com.store.model.User;

public interface CustomerDao {
	void registerCustomer(Customer customer);
	boolean isEmailUnique(String email); // input from the user [email is unique]
	User getById(String email);
}
