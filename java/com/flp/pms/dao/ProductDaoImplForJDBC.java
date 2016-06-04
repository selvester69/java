package com.flp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.Sub_Category;
import com.flp.pms.domain.Supplier;

public class ProductDaoImplForJDBC implements IProductDao {

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/productmanagementsystem";
			con = DriverManager.getConnection(dburl, "root", "India123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public List<Category> getAllCategory() {
		List<Category> categories = new ArrayList<Category>();
		Category category = null;
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			String query = "select * from category";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				category = new Category();
				category.setCategory_id(rs.getInt("category_id"));
				category.setCategory_name(rs.getString("category_name"));
				category.setDescription(rs.getString("description"));

				categories.add(category);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return categories;
	}

	public List<Sub_Category> getAllSubCategory() {
		List<Category> categories = getAllCategory();

		List<Sub_Category> sub_Categories = new ArrayList<Sub_Category>();
		Sub_Category sub_Category2 = null;
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			String query = "select * from Sub_category";
			rs = stmt.executeQuery(query);
			Category category = null;
			while (rs.next()) {
				sub_Category2 = new Sub_Category();
				sub_Category2.setSub_categoryId(rs.getInt("sub_categoryId"));
				sub_Category2.setSub_category_name(rs.getString("sub_category_name"));

				int categoryId = rs.getInt("category_Id");

				for (Category c : categories)
					if (categoryId == c.getCategory_id())
						category = c;

				sub_Category2.setCategory(category);

				sub_Categories.add(sub_Category2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sub_Categories;

	}

	public List<Supplier> getAllSupplier() {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		Supplier supplier = null;
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			String query = "select * from supplier";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				supplier = new Supplier();
				supplier.setSupplier_id(rs.getInt("supplier_id"));
				supplier.setFirst_name(rs.getString("first_name"));
				supplier.setLast_name(rs.getString("last_name"));
				supplier.setAddress(rs.getString("address"));
				supplier.setCity(rs.getString("city"));
				supplier.setState(rs.getString("state"));
				supplier.setPincode(rs.getString("pincode"));
				supplier.setContact_no(rs.getString("contact_no"));

				suppliers.add(supplier);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return suppliers;

	}

	public List<Discount> getAllDiscounts() {
		List<Discount> discounts = new ArrayList<Discount>();
		Discount discount = null;
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			String query = "select * from discount";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				discount = new Discount();
				discount.setDiscount_id(rs.getInt("discount_id"));
				discount.setDiscount_name(rs.getString("discount_name"));
				discount.setDescription(rs.getString("description"));
				discount.setDiscount_percentage(rs.getFloat("discount_percentage"));
				discount.setValid_thru(rs.getDate("valid_thru"));

				discounts.add(discount);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return discounts;

	}

	public void addProduct(Product product) {

		int count1 = 0;
		int count2 = 0;
		ResultSet rs = null;
		String query1 = "insert into product (product_name,description,manufacturing_date,expiry_date,"
				+ "maximum_retail_price,category_id,sub_categoryId,"
				+ "supplier_id,quantity,ratings)values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst1 = getConnection().prepareStatement(query1);

			pst1.setString(1, product.getProduct_name());
			pst1.setString(2, product.getDescription());
			pst1.setDate(3, new java.sql.Date(product.getManufacturing_date().getTime()));
			pst1.setDate(4, new java.sql.Date(product.getExpiry_date().getTime()));
			pst1.setDouble(5, product.getMaximum_retail_price());
			pst1.setInt(6, product.getCategory().getCategory_id());
			pst1.setInt(7, product.getSub_Category().getSub_categoryId());
			pst1.setInt(8, product.getSupplier().getSupplier_id());
			pst1.setDouble(9, product.getQuantity());
			pst1.setFloat(10, product.getRatings());

			count1 = pst1.executeUpdate();
			count1 = pst1.executeUpdate();

			String query2 = "select * from product";
			PreparedStatement pst2 = getConnection().prepareStatement(query2);

			rs = pst2.executeQuery();

			int id = 0;
			while (rs.next()) {

				id = rs.getInt("product_id");
			}

			String query3 = "insert into product_discount values(?,?)";
			PreparedStatement pst3 = getConnection().prepareStatement(query3);

			List<Discount> discnt = product.getDiscounts();
			for (Discount discount : discnt) {

				pst3.setInt(1, id);
				pst3.setInt(2, discount.getDiscount_id());
				count2 = pst3.executeUpdate();
			}

			System.out.println(count1);
			System.out.println(count2);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Map<Integer, Product> getAllProducts() {
		// return products;
		return null;
	}

}
