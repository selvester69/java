package com.flp.pms.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.Sub_Category;
import com.flp.pms.domain.Supplier;


public interface IProductDao {
	
	public Connection getConnection();
	
	public List<Category> getAllCategory();

	public List<Sub_Category> getAllSubCategory();

	public List<Supplier> getAllSupplier();

	public List<Discount> getAllDiscounts();

	public void addProduct(Product product);

	public Map<Integer, Product> getAllProducts();
	
}
