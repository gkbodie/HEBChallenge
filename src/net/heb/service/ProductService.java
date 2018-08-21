package net.heb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.heb.dao.ProductDao;
import net.heb.interfaces.IProductService;
import net.heb.model.Product;

@Service
public class ProductService implements IProductService {
	@Autowired
	ProductDao productDao;
	
	public void setProducts(Product product) {
		product.setProducts(productDao.setProducts(product));
	}
	
	public List<String> getListByFieldName(String fieldName) {
		return productDao.getListByFieldName(fieldName);
	}
	
	public void filterProducts(Product product) {
		product.setProducts(productDao.filterProducts(product));
	}
}
