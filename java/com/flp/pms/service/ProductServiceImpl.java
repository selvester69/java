package com.flp.pms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flp.pms.dao.IProductDao;
import com.flp.pms.dao.ProductDaoImplForJDBC;
import com.flp.pms.dao.ProductDaoImplForMap;
import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.Sub_Category;
import com.flp.pms.domain.Supplier;



public class ProductServiceImpl implements IProductService {
	/*private IProductDao iProductDao = new ProductDaoImplForMap();*/
	private IProductDao iProductDao = new ProductDaoImplForJDBC();

	public List<Category> getAllCategory() {
		return iProductDao.getAllCategory();
	}

	public List<Sub_Category> getAllSubCategory() {
		return iProductDao.getAllSubCategory();
	}

	public List<Supplier> getAllSupplier() {
		return iProductDao.getAllSupplier();
	}

	public List<Discount> getAllDiscounts() {
		return iProductDao.getAllDiscounts();
	}

	public void addProduct(Product product) {
		Map<Integer, Product> maps = iProductDao.getAllProducts();
		boolean flag = false;
		Set<Integer> product_IDS = maps.keySet();
		int product_idGenerated = generateProductId();
		// check for uniqueness
		if (maps.isEmpty()) {
			do {
				product_idGenerated = generateProductId();
				for (Integer product_id : product_IDS) {
					if (product_id == product_idGenerated) {
						flag = true;
						break;
					}
				}
			} while (flag);
		}
		product.setProduct_id(product_idGenerated);
		iProductDao.addProduct(product);
	}

	public int generateProductId() {
		return (int) (Math.random() * 10000);
	}

	public Map<Integer, Product> getAllProducts() {

		return iProductDao.getAllProducts();
	}

	public List<Product> getAllproductlist(){
		List<Product> productList = new ArrayList<Product>();
		Collection<Product> productCollection = getAllProducts().values();
		for(Product product:productCollection){
			productList.add(product);
		}
		return productList;
		
	}
	
	//searching product methods
	public Product searchByProductName(String productName) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getProduct_name().equalsIgnoreCase(productName)) {
				product = products;
				break;
			}
		}

		return product;
	}

	public Product searchBySupplierName(String SupplierName) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getSupplier().getFirst_name().equalsIgnoreCase(SupplierName)) {
				product = products;
				break;
			}
		}

		return product;
	}

	public Product searchByProductCategory(String category) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getCategory().getCategory_name().equalsIgnoreCase(category)) {
				product = products;
				break;
			}
		}

		return product;

	}

	public Product searchByProductSubCategory(String subCategory) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getSub_Category().getSub_category_name().equalsIgnoreCase(subCategory)) {
				product = products;
				break;
			}
		}

		return product;

	}

	public Product searchByProductRating(float rating) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getRatings() == rating) {
				product = products;
				break;
			}
		}

		return product;
	}

	public Product searchByProductId(int productid) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getProduct_id()==productid) {
				product = products;
				break;
			}
		}

		return product;
	}


	//updating product methods

	public Product updateProductDescription(String description, int productId) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getProduct_id()==productId) {
				products.setDescription(description);
				product = products;
				break;
			}
		}
		if(product!=null)
			iProductDao.getAllProducts().put(product.getProduct_id(), product);
		return product;
	}

	public Product updateProductName(String name, int productId) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getProduct_id()==productId) {
				products.setProduct_name(name);
				product = products;
				break;
			}
		}
		if(product!=null)
			iProductDao.getAllProducts().put(product.getProduct_id(), product);
		return product;
	}

	public Product updateProductManufacturing(Date manufacturingDate, int productId) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getProduct_id()==productId) {
				products.setManufacturing_date(manufacturingDate);
				product = products;
				break;
			}
		}
		if(product!=null)
			iProductDao.getAllProducts().put(product.getProduct_id(), product);
		return product;
	}

	public Product updateProductExpiryDate(Date expiryDate, int productId) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getProduct_id()==productId) {
				products.setExpiry_date(expiryDate);
				product = products;
				break;
			}
		}
		if(product!=null)
			iProductDao.getAllProducts().put(product.getProduct_id(), product);
		return product;
	}

	public Product updateProductMRP(double mrp, int productId) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getProduct_id()==productId) {
				products.setMaximum_retail_price(mrp);
				product = products;
				break;
			}
		}
		if(product!=null)
			iProductDao.getAllProducts().put(product.getProduct_id(), product);
		return product;
	}

	public Product updateProductQuantity(int quantity, int productId) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getProduct_id()==productId) {
				products.setQuantity(quantity);
				product = products;
				break;
			}
		}
		if(product!=null)
			iProductDao.getAllProducts().put(product.getProduct_id(), product);
		return product;
	}

	public Product updateProductRating(float rating, int productId) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getProduct_id()==productId) {
				products.setRatings(rating);
				product = products;
				break;
			}
		}
		if(product!=null)
			iProductDao.getAllProducts().put(product.getProduct_id(), product);
		return product;
	}

	
	public Product updateProductCategory(Category category, int productId) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getProduct_id()==productId) {
				products.setCategory(category);
				product = products;
				break;
			}
		}
		if(product!=null)
		iProductDao.getAllProducts().put(product.getProduct_id(), product);
		return product;
	}

	
	public Product updateProductSupplier(Supplier supplier, int productId) {
		Product product = null;
		List<Product> productlist = getAllproductlist();
		for (Product products : productlist) {
			if (products.getProduct_id()==productId) {
				products.setSupplier(supplier);
				product = products;
				break;
			}
		}
		if(product!=null)
		iProductDao.getAllProducts().put(product.getProduct_id(), product);
		return product;
	}


	
	
	}

	

