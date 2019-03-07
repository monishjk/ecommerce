package com.store.dao;

import java.util.List;

import com.store.model.Category;

public interface CategoryDao {
	boolean saveCategory(Category category);
	boolean deleteCategory(int cid);
	boolean updateCategory(Category category);
	List<Category> getAllProducts();
	Category getIdProducts(int id);
}
