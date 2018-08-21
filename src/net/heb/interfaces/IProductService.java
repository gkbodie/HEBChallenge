package net.heb.interfaces;

import java.util.List;

import net.heb.model.Product;

/* Side note - Interface as currently used is not useful since there is only one implementation. */
public interface IProductService { 
	/**
	 * Service implementation to set Product Data into Product Object
	 * @param product
	 */
	public void setProducts(Product product);
	
	/**
	 * Service implementation to get drop list data.
	 * @param fieldName valid values are productID, description, department and shelfLife
	 * @return A List of data used in drop downs.
	 */
	public List<String> getListByFieldName(String fieldName);
	
	/**
	 * Service implementation to retrieve Product data based on filtering criteria.
	 * @param product
	 */
	public void filterProducts(Product product);
}
