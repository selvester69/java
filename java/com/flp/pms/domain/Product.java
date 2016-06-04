package com.flp.pms.domain;

import java.util.Date;
import java.util.List;



public class Product {
	private int product_id;
	private String product_name;
	private String description;
	private Date manufacturing_date;
	private Date expiry_date;
	private double maximum_retail_price;
	private float ratings;
	private int quantity;
	
	private Category category;
	private Sub_Category sub_Category;
	private Supplier supplier;
	private List<Discount> discounts;
	
	
	
	public Product() {
		super();
	}

	


	public Product(int product_id, String product_name, String description, Date manufacturing_date, Date expiry_date,
			double maximum_retail_price, float ratings, int quantity, Category category, Sub_Category sub_Category,
			Supplier supplier, List<Discount> discounts) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.description = description;
		this.manufacturing_date = manufacturing_date;
		this.expiry_date = expiry_date;
		this.maximum_retail_price = maximum_retail_price;
		this.ratings = ratings;
		this.quantity = quantity;
		this.category = category;
		this.sub_Category = sub_Category;
		this.supplier = supplier;
		this.discounts = discounts;
	}




	public int getProduct_id() {
		return product_id;
	}



	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getManufacturing_date() {
		return manufacturing_date;
	}



	public void setManufacturing_date(Date manufacturing_date) {
		this.manufacturing_date = manufacturing_date;
	}



	public Date getExpiry_date() {
		return expiry_date;
	}



	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}



	public double getMaximum_retail_price() {
		return maximum_retail_price;
	}



	public void setMaximum_retail_price(double maximum_retail_price) {
		this.maximum_retail_price = maximum_retail_price;
	}



	public float getRatings() {
		return ratings;
	}



	public void setRatings(float ratings) {
		this.ratings = ratings;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public Sub_Category getSub_Category() {
		return sub_Category;
	}



	public void setSub_Category(Sub_Category sub_Category) {
		this.sub_Category = sub_Category;
	}



	public Supplier getSupplier() {
		return supplier;
	}



	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}



	public List<Discount> getDiscounts() {
		return discounts;
	}



	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((discounts == null) ? 0 : discounts.hashCode());
		result = prime * result + ((expiry_date == null) ? 0 : expiry_date.hashCode());
		result = prime * result + ((manufacturing_date == null) ? 0 : manufacturing_date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(maximum_retail_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + product_id;
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		result = prime * result + quantity;
		result = prime * result + Float.floatToIntBits(ratings);
		result = prime * result + ((sub_Category == null) ? 0 : sub_Category.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discounts == null) {
			if (other.discounts != null)
				return false;
		} else if (!discounts.equals(other.discounts))
			return false;
		if (expiry_date == null) {
			if (other.expiry_date != null)
				return false;
		} else if (!expiry_date.equals(other.expiry_date))
			return false;
		if (manufacturing_date == null) {
			if (other.manufacturing_date != null)
				return false;
		} else if (!manufacturing_date.equals(other.manufacturing_date))
			return false;
		if (Double.doubleToLongBits(maximum_retail_price) != Double.doubleToLongBits(other.maximum_retail_price))
			return false;
		if (product_id != other.product_id)
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (quantity != other.quantity)
			return false;
		if (Float.floatToIntBits(ratings) != Float.floatToIntBits(other.ratings))
			return false;
		if (sub_Category == null) {
			if (other.sub_Category != null)
				return false;
		} else if (!sub_Category.equals(other.sub_Category))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", description=" + description
				+ ", manufacturing_date=" + manufacturing_date + ", expiry_date=" + expiry_date
				+ ", maximum_retail_price=" + maximum_retail_price + ", ratings=" + ratings + ", quantity=" + quantity
				+ ",\n\t category=" + category + ",\n\t sub_Category=" + sub_Category + ",\n\t supplier=" + supplier
				+ ", discounts=" + discounts + "]";
	}


	


}
