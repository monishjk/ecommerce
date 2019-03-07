package com.store.dao;

import java.util.List;

import com.store.model.CartItem;
import com.store.model.User;

public interface CartItemDao {
	User getUser(String Email);
	void saveOrUpdateCartItem(CartItem cartItem);
	List<CartItem> getCartItem(String email);
	void removeCartItem(int itemId);
	CartItem getCartItemId(int itemId);
}
