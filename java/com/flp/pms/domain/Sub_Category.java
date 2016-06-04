package com.flp.pms.domain;



public class Sub_Category {
	private int sub_categoryId;
	private String sub_category_name;
	private Category category;
	
	
	
	
	
	public Sub_Category() {
		super();
	}
	public Sub_Category(int sub_categoryId, String sub_category_name, Category category) {
		super();
		this.sub_categoryId = sub_categoryId;
		this.sub_category_name = sub_category_name;
		this.category = category;
	}
	public int getSub_categoryId() {
		return sub_categoryId;
	}
	public void setSub_categoryId(int sub_categoryId) {
		this.sub_categoryId = sub_categoryId;
	}
	public String getSub_category_name() {
		return sub_category_name;
	}
	public void setSub_category_name(String sub_category_name) {
		this.sub_category_name = sub_category_name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + sub_categoryId;
		result = prime * result + ((sub_category_name == null) ? 0 : sub_category_name.hashCode());
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
		Sub_Category other = (Sub_Category) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (sub_categoryId != other.sub_categoryId)
			return false;
		if (sub_category_name == null) {
			if (other.sub_category_name != null)
				return false;
		} else if (!sub_category_name.equals(other.sub_category_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sub_Category [sub_categoryId=" + sub_categoryId + ",\t sub_category_name=" + sub_category_name
				+ ",\t category=" + category + "]";
	}
	
	
	
	
	
	

}
