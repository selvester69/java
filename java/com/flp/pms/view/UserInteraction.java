package com.flp.pms.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.Sub_Category;
import com.flp.pms.domain.Supplier;

import com.flp.pms.util.Validate;

public class UserInteraction {

	public Product AddProduct(List<Category> categories, List<Sub_Category> sub_Categories, List<Discount> discounts,
			List<Supplier> suppliers) {
		Product product = new Product();
		Scanner sc = new Scanner(System.in);
		boolean flag = false;

		// ---------------------------------------------------------------------------------
		/*
		 * String productName; do { System.out.println("enter product name");
		 * productName = sc.nextLine(); flag =
		 * Validate.isValidProductName(productName); if (!flag)
		 * System.out.println("invalid product name");
		 * 
		 * } while (!flag); product.setProduct_name(productName);
		 */

		// ---------------------------------------------------------------------------------
		/*
		 * System.out.println("enter product description"); String description =
		 * sc.nextLine(); product.setDescription(description);
		 */

		// ----------------------------------------------------------------------------------

		/*
		 * String manufacturingDate; do { System.out.println(
		 * "enter manufacturing date in format dd-mmm-yyyy"); manufacturingDate
		 * = sc.next(); flag = Validate.isValidDate(manufacturingDate); if
		 * (!flag) System.err.println("invalid date format"); } while (!flag);
		 * 
		 * product.setManufacturing_date(new Date(manufacturingDate));
		 */
		// ----------------------------------------------------------------------------------

		/*
		 * String expiryDate; boolean expDateFlag=false; do{
		 * 
		 * do { System.out.println("enter expiry date in format dd-mmm-yyyy");
		 * expiryDate = sc.next(); expDateFlag =
		 * Validate.isValidDate(expiryDate); if (!expDateFlag)
		 * System.err.println("invalid date"); } while (!expDateFlag);
		 * expDateFlag=Validate.isValidExpiryDate(new Date(expiryDate),new
		 * Date(manufacturingDate)); if (!expDateFlag) System.err.println(
		 * "expiry date should be future date"); }while(!expDateFlag);
		 * product.setExpiry_date(new Date(expiryDate));
		 */
		// ---------------------------------------------------------------------------------
		/*
		 * System.out.println("enter Max retail price"); double price =
		 * sc.nextDouble(); product.setMaximum_retail_price(price);
		 * 
		 */ // ---------------------------------------------------------------------------------
		/*
		 * float rating; do { System.out.println("enter rating"); rating =
		 * sc.nextFloat(); flag = Validate.isValidRating(rating); if (!flag)
		 * System.err.println("rating should be between 1.0 and 5.0");
		 * 
		 * } while (!flag); product.setRatings(rating);
		 * 
		 * 
		 * //
		 * ---------------------------------------------------------------------
		 * ------------ int quantity=0; do{ System.out.println(
		 * "enter product quantity"); quantity = sc.nextInt(); flag =
		 * Validate.isValidQuantity(quantity); if(!flag) System.err.println(
		 * "quantity should be positive integer"); }while(!flag);
		 * product.setQuantity(quantity);
		 */ // ---------------------------------------------------------------------------------

		Category category = getCategory(categories);
		product.setCategory(category);
		// ----------------------------------------------------------------------------------
		// sub category details
		Sub_Category sub_Category = getSubCategory(sub_Categories, category);
		product.setSub_Category(sub_Category);
		// ----------------------------------------------------------------------------------
		// Supplier details
		Supplier supplier = getSupplier(suppliers);
		product.setSupplier(supplier);
		// -----------------------------------------------------------------------------------
		// discounts
		List<Discount> discounts2 = getDiscount(discounts);
		product.setDiscounts(discounts2);
		// -----------------------------------------------------------------------------------
		return product;

	}

	public Supplier getSupplier(List<Supplier> suppliers) {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		Supplier supplier = null;
		int choice;
		do {

			System.out.println("choose supplier id:");

			for (Supplier supplier1 : suppliers) {
				System.out.print(supplier1.getSupplier_id() + "\t");
				System.out.print(supplier1.getFirst_name() + "\t");
				System.out.print(supplier1.getLast_name() + "\t");
				System.out.print(supplier1.getAddress() + "\t");
				System.out.print(supplier1.getCity() + "\t");
				System.out.print(supplier1.getState() + "\t");
				System.out.println(supplier1.getPincode());

			}

			choice = sc.nextInt();
			// validating the category
			for (Supplier supplier1 : suppliers) {
				if (choice == supplier1.getSupplier_id()) {
					supplier = supplier1;
					flag = true;
					break;
				}
			}

			if (!flag)
				System.out.println("please choose valid category id:");

		} while (!flag);

		return supplier;

	}

	public Category getCategory(List<Category> categories) {

		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		Category category = null;
		int choice;
		do {

			System.out.println("choose category id:");

			for (Category category1 : categories) {
				System.out.print(category1.getCategory_id() + "\t");
				System.out.print(category1.getCategory_name() + "\t");
				System.out.println(category1.getDescription());
			}

			choice = sc.nextInt();
			// validating the category
			for (Category category1 : categories) {
				if (choice == category1.getCategory_id()) {
					category = category1;
					flag = true;
					break;
				}
			}

			if (!flag)
				System.out.println("please choose valid category id:");

		} while (!flag);

		return category;
	}

	public Sub_Category getSubCategory(List<Sub_Category> categories, Category category) {
		Sub_Category subCategory = null;
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean flag = false;
		do {
			System.out.println("choose product sub Category");
			for (Sub_Category subCategory2 : categories) {
				if (subCategory2.getCategory().getCategory_id() == category.getCategory_id()) {
					System.out.print(subCategory2.getSub_categoryId() + "\t");
					System.out.println(subCategory2.getSub_category_name());

				}
			}
			option = sc.nextInt();

			// check valid category
			for (Sub_Category subCategory2 : categories) {
				if (option == subCategory2.getSub_categoryId()) {
					subCategory = subCategory2;
					flag = true;
					break;
				}
			}
			if (!flag)
				System.out.println("please choose the valid sub category");

		} while (!flag);
		return subCategory;

	}

	public List<Discount> getDiscount(List<Discount> discounts) {
		List<Discount> discounts2 = new ArrayList<Discount>();
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean flag = false;
		String choice = null;
		do {
			do {
				System.out.println("choose discounts for the product");
				for (Discount discount : discounts) {
					// checking valid discounts
					if (discount.getValid_thru().after(new Date())) {
						System.out.print(discount.getDiscount_id() + "\t");
						System.out.print(discount.getDiscount_name() + "\t");
						System.out.print(discount.getDescription() + "\t");
						System.out.println(discount.getDiscount_percentage() + "\t");

					}
				}
				option = sc.nextInt();

				// validate discount
				L: for (Discount discount : discounts) {
					if (discount.getDiscount_id() == option) {
						discounts2.add(discount);
						flag = true;
						break L;
					}
				}
				if (!flag)
					System.out.println("Choose valid discount Id");
			} while (!flag);
			System.out.println("you wish to add more discounts for this product?[Y|N]");
			choice = sc.next();
		} while (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y');
		return discounts2;
	}

	public String getProductName() {
		System.out.println("enter product name ");
		Scanner sc = new Scanner(System.in);
		String productName = sc.nextLine();
		return productName;

	}

	public String getSupplierName() {
		System.out.println("enter Supplier name");
		Scanner sc = new Scanner(System.in);
		String supplierName = sc.nextLine();
		return supplierName;
	}

	public String getCategoryName() {
		System.out.println("enter Category name");
		Scanner sc = new Scanner(System.in);
		String categoryName = sc.nextLine();
		return categoryName;
	}

	public String getSubCategoryName() {
		System.out.println("enter SubCategory name");
		Scanner sc = new Scanner(System.in);
		String subCategory = sc.nextLine();
		return subCategory;
	}

	public float getRatings() {
		System.out.println("enter product Rating");
		Scanner sc = new Scanner(System.in);
		float ratings = sc.nextFloat();
		return ratings;
	}

	public void searchedProduct(Product product) {
		System.out.println("searched product=" + product);
	}

	public void deleteProductDetails(Map<Integer, Product> products, Product product) {
		Set<Integer> productKeys = products.keySet();
		boolean confirm = userConfirmation();
		if (confirm) {
			l1: for (int ids : productKeys) {
				if (product.getProduct_id() == ids) {
					products.remove(product.getProduct_id(), product);
					break l1;
				}
			}
			System.out.println("product deleted successfully");
		} else {
			System.out.println("product not deleted");
			System.out.println("something went wrong");
		}
	}

	public int getProductId() {
		System.out.println("enter Id of the product you wish to delete ");

		Scanner sc = new Scanner(System.in);
		int productId = sc.nextInt();
		return productId;

	}

	public void printAllProducts(List<Product> allproductlist) {
		for (Product list : allproductlist) {
			// print product here
			System.out.println(list);
		}

	}

	public boolean userConfirmation() {
		System.out.println("are you sure you want to Proceed");
		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0);
		if (c == 'y' || c == 'Y')
			return true;
		else
			return false;

	}

	public void modifiedProduct(Product product) {
		if (product != null) {
			System.out.println("product has been modified");
			System.out.println(product);
		} else
			System.out.println("your product has not been modified");

	}

	public Date getProductManufacturingDate() {
		String manufacturingDate;
		Scanner sc = new Scanner(System.in);

		boolean flag = false;
		do {
			System.out.println("enter manufacturing date in format dd-mmm-yyyy");
			manufacturingDate = sc.next();
			flag = Validate.isValidDate(manufacturingDate);
			if (!flag)
				System.err.println("invalid date format");
		} while (!flag);
		return new Date(manufacturingDate);
	}

	public Date getProductExpiryDate() {
		String expiryDate;
		Scanner sc = new Scanner(System.in);
		boolean expDateFlag = false;
		do {

			do {
				System.out.println("enter expiry date in format dd-mmm-yyyy");
				expiryDate = sc.next();
				expDateFlag = Validate.isValidDate(expiryDate);
				if (!expDateFlag)
					System.err.println("invalid date");
			} while (!expDateFlag);
			expDateFlag = Validate.isValidExpiryDate(new Date(expiryDate), getProductManufacturingDate());
			if (!expDateFlag)
				System.err.println("expiry date should be future date");
		} while (!expDateFlag);
		return new Date(expiryDate);
	}

	public String getProductDescription() {
		System.out.println("enter product description ");
		Scanner sc = new Scanner(System.in);
		String description = sc.nextLine();
		return description;
	}

	public double getProductMRP() {
		System.out.println("enter the new MRP of the product");
		Scanner sc = new Scanner(System.in);
		double mrp = sc.nextDouble();
		return mrp;

	}

	public int getProductQuantity() {
		System.out.println("enter new Quantity");
		Scanner sc = new Scanner(System.in);
		int quantity = sc.nextInt();
		return quantity;
	}

}
