package com.flp.pms.view;

import java.util.Date;
import java.util.Scanner;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.Sub_Category;
import com.flp.pms.domain.Supplier;
import com.flp.pms.service.IProductService;
import com.flp.pms.service.ProductServiceImpl;


public class BootClass {

	public static void main(String[] args) {

		menuSelection();

	}

	public static void menuSelection() {

		Scanner sc = new Scanner(System.in);
		int option;
		String choice = null;
		IProductService iProductService = new ProductServiceImpl();
		UserInteraction userInteraction = new UserInteraction();
		do {
			System.out.println("1.Create Product");
			System.out.println("2.Modify Product");
			System.out.println("3.Remove Product");
			System.out.println("4.View All Product");
			System.out.println("5.Search Product");
			System.out.println("6.Exit");
			System.out.println("enter your option");
			option = sc.nextInt();
			switch (option) {

			case 1:
				Product product = userInteraction.AddProduct(iProductService.getAllCategory(),
						iProductService.getAllSubCategory(), iProductService.getAllDiscounts(),
						iProductService.getAllSupplier());
				iProductService.addProduct(product);
				break;
				

			case 2:
				userInteraction.printAllProducts(iProductService.getAllproductlist());
				System.out.println("enter the id of product you wish to update ");
				int productId = sc.nextInt();
				System.out.println("enter the field you wish to update");
				System.out.println(
						"1. Product Name" + "\n2. Product Description" + "\n3. Manufacturing Date" + "\n4. Expire Date"
								+ "\n5. MRP" + "\n6. Quantity" + "\n7. Rating" + "\n8. Category" + "\n9.  Supplier");

				System.out.println("enter your option");
				int updateOption = sc.nextInt();
				switch (updateOption) {

				case 1:
					System.out.println("Updating product by name");
					String name = userInteraction.getProductName();
					userInteraction.modifiedProduct(iProductService.updateProductName(name, productId));
					break;
				case 2:
					System.out.println("Updating product by Description");
					String description = userInteraction.getProductDescription();
					userInteraction.modifiedProduct(iProductService.updateProductDescription(description, productId));
					break;
				case 3:
					System.out.println("Updating product by Manufacturing Date");
					Date manufacturingDate = userInteraction.getProductManufacturingDate();
					userInteraction
							.modifiedProduct(iProductService.updateProductManufacturing(manufacturingDate, productId));
					break;
				case 4:
					System.out.println("Updating product by Expiry Date");
					Date expiryDate = userInteraction.getProductExpiryDate();
					userInteraction.modifiedProduct(iProductService.updateProductExpiryDate(expiryDate, productId));
					break;
				case 5:
					System.out.println("Updating product by MRP");
					double mrp = userInteraction.getProductMRP();
					userInteraction.modifiedProduct(iProductService.updateProductMRP(mrp, productId));
					break;
				case 6:
					System.out.println("Updating product by quantity");
					int quantity = userInteraction.getProductQuantity();
					userInteraction.modifiedProduct(iProductService.updateProductQuantity(quantity, productId));
					break;
				case 7:
					System.out.println("Updating product by Rating");
					float rating = userInteraction.getRatings();
					userInteraction.modifiedProduct(iProductService.updateProductRating(rating, productId));
					break;
				case 8:
					System.out.println("Updating product by Category");
					Category category = userInteraction.getCategory(iProductService.getAllCategory());
					userInteraction.modifiedProduct(iProductService.updateProductCategory(category, productId));
					break;

				case 9:
					System.out.println("Updating product by Supplier");
					Supplier supplier = userInteraction.getSupplier(iProductService.getAllSupplier());
					userInteraction.modifiedProduct(iProductService.updateProductSupplier(supplier, productId));
					break;
				}

				break;

			case 3:
				int deteleProductId = userInteraction.getProductId();
				userInteraction.deleteProductDetails(iProductService.getAllProducts(),
						iProductService.searchByProductId(deteleProductId));
				break;
			case 4:
				userInteraction.printAllProducts(iProductService.getAllproductlist());
				break;

			case 5:
				String searchChoiceRepeat = null;
				do {
					System.out.println("1. Search Product by name");
					System.out.println("2. Search Product by Producer(Supplier)");
					System.out.println("3. Search Product by Category");
					System.out.println("4. Search Product by Sub-Category");
					System.out.println("5. Search Product by Rating");

					int searchChoice = sc.nextInt();
					switch (searchChoice) {
					case 1:
						System.out.println("searching product by name");
						String name = userInteraction.getProductName();
						userInteraction.searchedProduct(iProductService.searchByProductName(name));
						break;
					case 2:
						System.out.println("searching product by supplier name");
						String supplierName = userInteraction.getSupplierName();
						userInteraction.searchedProduct(iProductService.searchBySupplierName(supplierName));
						break;
					case 3:
						System.out.println("searching product by product category");
						String categoryName = userInteraction.getCategoryName();
						userInteraction.searchedProduct(iProductService.searchByProductCategory(categoryName));
						break;
					case 4:
						System.out.println("searching product by sub category");
						String subCategoryName = userInteraction.getSubCategoryName();
						userInteraction.searchedProduct(iProductService.searchByProductSubCategory(subCategoryName));
						break;
					case 5:
						System.out.println("searching product by product rating");
						float rating = userInteraction.getRatings();
						userInteraction.searchedProduct(iProductService.searchByProductRating(rating));
						break;
					default:
						break;
					}
					System.out.println("You wish to continue search?[Y|N]");
					searchChoiceRepeat = sc.next();
				} while (searchChoiceRepeat.charAt(0) == 'y' || searchChoiceRepeat.charAt(0) == 'Y');
				break;

			case 6:
				System.exit(0);
				break;

			}
			System.out.println("You wish to continue?[Y|N]");
			choice = sc.next();
		} while (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y');
	}

	public static boolean userConfirmation() {
		UserInteraction userInteraction = new UserInteraction();
		return userInteraction.userConfirmation();
	}

}
