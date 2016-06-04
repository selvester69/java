package com.flp.pms.util;

import java.util.Date;

public class Validate {
	public static boolean isValidProductName(String name){
		return name.matches("[A-Z][a-z$_0-9\\s]*");
	}
	public static boolean isValidDate(String date){
		return date.matches("([1-2][0-9]|[1-9]|30|31)-(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)-[1-2]\\d{3}");
	}
	public static boolean isValidExpiryDate(Date expiryDate,Date manufacturingDate){
		
		
		return expiryDate.after(new Date())&& expiryDate.after(manufacturingDate) ;
	}
	public static boolean isValidContactNumber(String number){
		return number.matches("\\d{10}");
	}
	public static boolean isValidRating(float rating){
		if(rating>=0.0f && rating<=5.0f)
			return true;
		else 
			return false;
	}
	public static boolean isValidQuantity(int quantity){
		return quantity>0;
	}

}
