package net.heb.interfaces;

import java.util.List;

import net.heb.model.Product;

/* Side note - Interface as currently used is not useful since there is only one implementation. */
public interface IProductDao {
	/**
	 * Retrieves data from Product table into a List, no filter criteria. 
	 * @param product
	 * @return A list of product data.
	 */
	public List<Product> setProducts(Product product);
	
	/**
	 * Retrieves a list of Product data based on filtered criteria.
	 * @param product
	 * @return A filtered list of product data.
	 */
	public List<Product> filterProducts(Product product);
	
	/**
	 * Helper method used to retrieve drop down data depending on the field passed in
	 * @param fieldName
	 * @return List of data for a drop down.
	 */
	public List<String> getListByFieldName(String fieldName);
}
