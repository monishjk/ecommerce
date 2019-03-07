package com.store.dao;

import java.util.List;

import com.store.model.Supplier;

public interface SupplierDao {
	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(int id);
	public boolean updateSupplier(Supplier supplier);
	public List<Supplier> listSupplier();
	public Supplier getSupplier(int id);
}