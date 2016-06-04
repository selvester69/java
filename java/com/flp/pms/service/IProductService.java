package com.flp.pms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.Sub_Category;
import com.flp.pms.domain.Supplier;


public interface IProductService {

	List<Category> getAllCategory();

	List<Sub_Category> getAllSubCategory();

	List<Supplier> getAllSupplier();

	List<Discount> getAllDiscounts();

	public void addProduct(Product product);

	public Map<Integer, Product> getAllProducts();
	
	public Product searchByProductName(String productName);
	
	public Product searchBySupplierName(String SupplierName);
	
	public Product searchByProductCategory(String category);
	
	public Product searchByProductSubCategory(String subCategory);
	
	public Product searchByProductRating(float rating);

	public Product searchByProductId(int productid);

	public List<Product> getAllproductlist();
	
	public Product updateProductDescription(String description, int productId);

	public Product updateProductName(String name, int productId);

	public Product updateProductManufacturing(Date manufacturingDate, int productId);

	public Product updateProductExpiryDate(Date expiryDate, int productId);

	public Product updateProductMRP(double mrp, int productId);

	public Product updateProductQuantity(int quantity, int productId);

	public Product updateProductRating(float rating, int productId);

	public Product updateProductCategory(Category category, int productId);

	public Product updateProductSupplier(Supplier supplier, int productId);

	

	

}
