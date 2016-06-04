package com.flp.pms.domain;


public class Category {
	private int category_id;
	private String category_name;
	private String description;
	
	public Category() {
		
	}
	
	
	public Category(int category_id, String category_name, String description) {
		
		this.category_id = category_id;
		this.category_name = category_name;
		this.description = description;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category_id;
		result = prime * result + ((category_name == null) ? 0 : category_name.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Category other = (Category) obj;
		if (category_id != other.category_id)
			return false;
		if (category_name == null) {
			if (other.category_name != null)
				return false;
		} else if (!category_name.equals(other.category_name))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ",\t category_name=" + category_name + ",\t description="
				+ description + "]";
	}
	
	
}
