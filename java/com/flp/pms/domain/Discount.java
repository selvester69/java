package com.flp.pms.domain;

import java.util.Date;

public class Discount {
	
	private int discount_id;
	private String discount_name;
	private String description;
	private double discount_percentage;
	private Date valid_thru;
	public Discount() {
		super();
	}
	public Discount(int discount_id, String discount_name, String description, double discount_percentage,
			Date valid_thru) {
		super();
		this.discount_id = discount_id;
		this.discount_name = discount_name;
		this.description = description;
		this.discount_percentage = discount_percentage;
		this.valid_thru = valid_thru;
	}
	public int getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
	}
	public String getDiscount_name() {
		return discount_name;
	}
	public void setDiscount_name(String discount_name) {
		this.discount_name = discount_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getDiscount_percentage() {
		return discount_percentage;
	}
	public void setDiscount_percentage(double discount_percentage) {
		this.discount_percentage = discount_percentage;
	}
	public Date getValid_thru() {
		return valid_thru;
	}
	public void setValid_thru(Date valid_thru) {
		this.valid_thru = valid_thru;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + discount_id;
		result = prime * result + ((discount_name == null) ? 0 : discount_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount_percentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((valid_thru == null) ? 0 : valid_thru.hashCode());
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
		Discount other = (Discount) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discount_id != other.discount_id)
			return false;
		if (discount_name == null) {
			if (other.discount_name != null)
				return false;
		} else if (!discount_name.equals(other.discount_name))
			return false;
		if (Double.doubleToLongBits(discount_percentage) != Double.doubleToLongBits(other.discount_percentage))
			return false;
		if (valid_thru == null) {
			if (other.valid_thru != null)
				return false;
		} else if (!valid_thru.equals(other.valid_thru))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Discount [discount_id=" + discount_id + ", discount_name=" + discount_name + ", description="
				+ description + ", discount_percentage=" + discount_percentage + ", valid_thru=" + valid_thru + "]";
	}
	

}
