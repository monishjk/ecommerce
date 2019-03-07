package com.store.dao;

import java.util.List;

import com.store.model.Category;
import com.store.model.Product;

public interface ProductDao {
	boolean saveProduct(Product product);
	boolean deleteProduct(int id);
	boolean updateProduct(Product product);
	Product getId(int id);
	public List<Product> getAllProduct();
	List<Category> getAllCategories();
}
