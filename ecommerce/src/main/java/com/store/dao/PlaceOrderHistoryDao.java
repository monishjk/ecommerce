package com.store.dao;

import java.util.List;

import com.store.model.PlaceOrderHistory;

public interface PlaceOrderHistoryDao {	
	void addPlaceOrderHistory(PlaceOrderHistory placeOrderHistory);
	List<PlaceOrderHistory> getAllPlaceOrderHistory(String email);
}
