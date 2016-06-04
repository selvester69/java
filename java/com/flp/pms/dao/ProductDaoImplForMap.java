package com.flp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.Sub_Category;
import com.flp.pms.domain.Supplier;


public class ProductDaoImplForMap implements IProductDao{
	//repository
	Map<Integer, Product> products=new HashMap<Integer, Product>();
	
public List<Category> getAllCategory(){
		
		List<Category> categories = new ArrayList<Category>();
		//jdbc code
		
		return categories;	
	}

	
	public List<Sub_Category> getAllSubCategory(){
		List<Sub_Category> sub_Category = new ArrayList<Sub_Category>();
		sub_Category.add(new Sub_Category(101, "mobile", new Category(1, "Electronics", "Electronic Items")));
		sub_Category.add(new Sub_Category(102, "data storage", new Category(1, "Electronics", "Electronic Items")));
		sub_Category.add(new Sub_Category(103, "powerbank", new Category(1, "Electronics", "Electronic Items")));
		
		sub_Category.add(new Sub_Category(201, "formals", new Category(2, "Clothing", "All Cloth Varity")));
		sub_Category.add(new Sub_Category(202, "casuals",new Category(2, "Clothing", "All Cloth Varity")));
		sub_Category.add(new Sub_Category(203, "sports wear",new Category(2, "Clothing", "All Cloth Varity")));
		
		sub_Category.add(new Sub_Category(301, "Diabetic Metre", new Category(3, "Health&Care", "Health And Hospitality")));
		sub_Category.add(new Sub_Category(302, "Blood Pressure Metre", new Category(3, "Health&Care", "Health And Hospitality")));
		sub_Category.add(new Sub_Category(303, "Diabetic Shoes", new Category(3, "Health&Care", "Health And Hospitality")));
		
		sub_Category.add(new Sub_Category(401, "Dining Sets", new Category(4, "HouseHolds", "HouseHold Items")));
		sub_Category.add(new Sub_Category(402, "Cooker", new Category(4, "HouseHolds", "HouseHold Items")));
		sub_Category.add(new Sub_Category(403, "Knife", new Category(4, "HouseHolds", "HouseHold Items")));
		sub_Category.add(new Sub_Category(404, "Glasses", new Category(4, "HouseHolds", "HouseHold Items")));
		
		sub_Category.add(new Sub_Category(501, "Bat", new Category(5, "Sports", "Games related Items")));
		sub_Category.add(new Sub_Category(502, "racquet", new Category(5, "Sports", "Games related Items")));
		sub_Category.add(new Sub_Category(503, "shuttlecock", new Category(5, "Sports", "Games related Items")));
		sub_Category.add(new Sub_Category(504, "ball", new Category(5, "Sports", "Games related Items")));
		
		return sub_Category;
	
	}

	public List<Supplier> getAllSupplier() {
		List<Supplier> suppliers=new ArrayList<Supplier>();
		suppliers.add(new Supplier(111, "Tom", "Jerry", "North Avvenue", "Chennai", "Tamil Nadu", "600041", "6576575"));
		suppliers.add(new Supplier(222, "Jack", "Thomson", "South Avvenue", "Chennai", "Tamil Nadu", "600341", "78987978"));
		suppliers.add(new Supplier(333, "Kamal", "Emi", "West Avvenue", "Chennai", "Tamil Nadu", "600001", "787665765"));
		suppliers.add(new Supplier(444, "Annie", "Kenn", "EAST Avvenue", "Pune", "Maharastra", "600121", "5464565645"));
		suppliers.add(new Supplier(555, "Vimal", "Desai", "7th Avvenue", "Pune", "Maharastra", "600121", "87686787"));
		suppliers.add(new Supplier(666, "Bimal", "Singh", "12th Avvenue", "Pune", "Maharastra", "600121", "12456767"));
		return suppliers;
		
	}

	@SuppressWarnings("deprecation")
	public List<Discount> getAllDiscounts() {
		List<Discount> discounts=new ArrayList<Discount>();
		discounts.add(new Discount(123, "Mega Offer", "Mega offer From Jan to Feb", 12.4, new Date(2009-1900, 4, 23)));
		discounts.add(new Discount(333, "Dewali Offer", "Dewali offer ", 12.4, new Date(2018-1900, 4, 23)));
		discounts.add(new Discount(678, "New Year Offer", "New Year offer ", .50, new Date(2020-1900, 4, 23)));
		discounts.add(new Discount(1234, "X'Mas Offer", "Xmas offer ", .55, new Date(2019-1900, 4, 23)));
		discounts.add(new Discount(340, "Pongal Offer", "Pongal offer ", 12.78, new Date(2017-1900, 4, 23)));
		
		
		return discounts;
	}
	
	public void addProduct(Product product) {
		products.put(product.getProduct_id(), product);
		
	}

	public Map<Integer, Product> getAllProducts() {
		return products;
	}


	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
