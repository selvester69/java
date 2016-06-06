package com.flp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
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
	
	public List<Product> getAllproductlist(){
		List<Product> productList = new ArrayList<Product>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		Category c = null;
		Sub_Category sub = null;
		Supplier supplier = null;
		
		try {
			product = new Product();
			c = new Category();
			sub = new Sub_Category();
			supplier = new Supplier();
			con = getConnection();
			String query = "SELECT p.product_id,p.product_name,p.description,p.manufacturing_date,p.expiry_date,p.maximum_retail_price,"+
					"p.ratings,p.quantity,c.category_id,c.category_name,c.description,sub.sub_categoryId,"+
					"sub.sub_category_name,s.supplier_id,s.first_name,s.last_name,s.address,s.city,s.state,s.pincode,"+
					"s.contact_no FROM product p,category c,sub_category sub,supplier s"+
					"WHERE p.category_id=c.category_id"+
					"AND p.sub_categoryId=sub.sub_categoryId"+
					"AND p.supplier_id = s.supplier_id";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()){
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setDescription(rs.getString("description"));
				product.setManufacturing_date(rs.getDate("manufacturing_date"));
				product.setExpiry_date(rs.getDate("expiry_date"));
				product.setMaximum_retail_price(rs.getDouble("maximum_retail_price"));
				product.setRatings(rs.getFloat("ratings"));
				product.setQuantity(rs.getInt("quantity"));
				
				c.setCategory_id(rs.getInt("category_id"));
				c.setCategory_name(rs.getString("category_name"));
				c.setDescription(rs.getString(11));
			
				product.setCategory(c);
				
				sub.setSub_categoryId(rs.getInt("sub_categoryId"));
				sub.setSub_category_name(rs.getString("sub_category_name"));
				sub.setCategory(c);
				
				product.setSub_Category(sub);
				
				supplier.setSupplier_id(rs.getInt("supplier_id"));
				supplier.setFirst_name(rs.getString("first_name"));
				supplier.setLast_name(rs.getString("last_name"));
				supplier.setAddress(rs.getString("address"));
				supplier.setCity(rs.getString("city"));
				supplier.setState(rs.getString("state"));
				supplier.setPincode(rs.getString("pincode"));
				supplier.setContact_no(rs.getString("contact_no"));
				
				product.setSupplier(supplier);
				
				//product.setDiscounts(discounts);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(con!=null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
				if(rs!=null)
					rs.close();
				
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		
		
		return productList;
	}
	
	public boolean updateProductName(String name, int productId) {
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		String query="update table product set product_name = ? where product_id = ? ";
		 try {
			pstmt = getConnection().prepareStatement(query);
			 pstmt.setString(1,name);
			 pstmt.setInt(2, productId);
			 pstmt.executeUpdate();
			 int countrow = pstmt.executeUpdate();
			 if(countrow==0)
				 return false;
			 else
				 return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		 return flag;
	}
	
	public boolean updateProductDescription(String description, int productId) {
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		String query="update table product set description = ? where product_id = ? ";
		 try {
			pstmt = getConnection().prepareStatement(query);
			 pstmt.setString(1,description);
			 pstmt.setInt(2, productId);
			 pstmt.executeUpdate();
			 int countrow = pstmt.executeUpdate();
			 if(countrow==0)
				 flag=false;
			 else
				 flag= true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		 return flag;
		
	}
	
	public boolean updateProductManufacturing(java.util.Date manufacturingDate, int productId) {
		
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		String query="update table product set manufacturingDate = ? where product_id = ? ";
		 try {
			pstmt = getConnection().prepareStatement(query);
			 pstmt.setDate(1,new java.sql.Date(manufacturingDate.getTime()));
			 pstmt.setInt(2, productId);
			 pstmt.executeUpdate();
			 int countrow = pstmt.executeUpdate();
			 if(countrow==0)
				 flag=false;
			 else
				 flag= true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		 return flag;
	}

	public boolean updateProductExpiryDate(java.util.Date expiryDate, int productId) {
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		String query="update table product set expiryDate = ? where product_id = ? ";
		 try {
			pstmt = getConnection().prepareStatement(query);
			 pstmt.setDate(1,new java.sql.Date(expiryDate.getTime()));
			 pstmt.setInt(2, productId);
			 pstmt.executeUpdate();
			 int countrow = pstmt.executeUpdate();
			 if(countrow==0)
				 flag=false;
			 else
				 flag= true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		 return flag;
	}

	public boolean updateProductMRP(double mrp, int productId) {
		
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		String query="update table product set maximum_retail_price = ? where product_id = ? ";
		 try {
			pstmt = getConnection().prepareStatement(query);
			 pstmt.setDouble(1,mrp);
			 pstmt.setInt(2, productId);
			 pstmt.executeUpdate();
			 int countrow = pstmt.executeUpdate();
			 if(countrow==0)
				 flag=false;
			 else
				 flag= true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		 return flag;
	}
	
	public boolean updateProductQuantity(int quantity, int productId) {
		
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		String query="update table product set quantity = ? where product_id = ? ";
		 try {
			pstmt = getConnection().prepareStatement(query);
			 pstmt.setInt(1,quantity);
			 pstmt.setInt(2, productId);
			 pstmt.executeUpdate();
			 int countrow = pstmt.executeUpdate();
			 if(countrow==0)
				 flag=false;
			 else
				 flag= true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		 return flag;
	}
	
	public boolean updateProductRating(float rating, int productId) {

		PreparedStatement pstmt = null;
		boolean flag = false;
		
		String query="update table product set ratings = ? where product_id = ? ";
		 try {
			pstmt = getConnection().prepareStatement(query);
			 pstmt.setFloat(1,rating);
			 pstmt.setInt(2, productId);
			 pstmt.executeUpdate();
			 int countrow = pstmt.executeUpdate();
			 if(countrow==0)
				 flag=false;
			 else
				 flag= true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		 return flag;
	}

	public boolean updateProductCategory(Category category, int productId) {
		
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		String query="update table product set category_id = ? where product_id = ? ";
		 try {
			pstmt = getConnection().prepareStatement(query);
			 pstmt.setInt(1,category.getCategory_id());
			 pstmt.setInt(2, productId);
			 pstmt.executeUpdate();
			 int countrow = pstmt.executeUpdate();
			 if(countrow==0)
				 flag=false;
			 else
				 flag= true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		 return flag;
	}
	
	public boolean updateProductSupplier(Supplier supplier, int productId) {
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		String query="update table product set supplier_id = ? where product_id = ? ";
		 try {
			pstmt = getConnection().prepareStatement(query);
			 pstmt.setInt(1,supplier.getSupplier_id());
			 pstmt.setInt(2, productId);
			 pstmt.executeUpdate();
			 int countrow = pstmt.executeUpdate();
			 if(countrow==0)
				 flag=false;
			 else
				 flag= true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
		 return flag;
	}

	
	public boolean deleteProduct(int deteleProductId) {
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2 = null;
		boolean flag = false;
		
		try {
			con=getConnection();
			String query = "delete from product where product_id=?  ";
			String query2 = "delete from product_discount where product_id=?";
			
			pstmt = con.prepareStatement(query);
			pstmt2 = con.prepareStatement(query2);
			
			pstmt.setInt(1,deteleProductId);
			pstmt2.setInt(1,deteleProductId );
			int count=pstmt.executeUpdate();
			int count2 = pstmt.executeUpdate();
			if(count==0 && count2==0)
				flag=false;
			else
				flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(con!=null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
				if(pstmt2!=null)
					pstmt2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
		
		}

}
