package com.flp.pms.domain;

public class Supplier {
	private int supplier_id;
	private String first_name;
	private String last_name;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String contact_no;
	
	
	public Supplier() {
		super();
	}


	public Supplier(int supplier_id, String first_name, String last_name, String address, String city, String state,
			String pincode, String contact_no) {
		super();
		this.supplier_id = supplier_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.contact_no = contact_no;
	}


	public int getSupplier_id() {
		return supplier_id;
	}


	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getContact_no() {
		return contact_no;
	}


	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((contact_no == null) ? 0 : contact_no.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + supplier_id;
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
		Supplier other = (Supplier) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (contact_no == null) {
			if (other.contact_no != null)
				return false;
		} else if (!contact_no.equals(other.contact_no))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (supplier_id != other.supplier_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", \tfirst_name=" + first_name + ", \tlast_name=" + last_name
				+ ",\t address=" + address + ", \tcity=" + city + ", \tstate=" + state + ",\t pincode=" + pincode
				+ ",\t contact_no=" + contact_no + "]";
	}
	
	
	
}
