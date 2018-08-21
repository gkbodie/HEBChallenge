package net.heb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable{
	private static final long serialVersionUID = 772267826061167427L;
	
	/* Fields to display table data */
	private String productID = "";
	private String description = "";
	private String lastSold = "";
	private String shelfLife = "";
	private String department = "";
	private BigDecimal price = new BigDecimal(0.00);
	private String unit = "";
	private int xFor = 0;
	private BigDecimal cost = new BigDecimal(0.00);
	/* End table display data */
	
	/* Extra filtering criteria, not used in table display */
	private String priceMin = "";
	private String priceMax = "";
	private String minLastSold = "";
	private String maxLastSold = "";
	
	/* List of fields to display table data */
	List<Product> products = new ArrayList<Product>();
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLastSold() {
		return lastSold;
	}
	public void setLastSold(String lastSold) {
		this.lastSold = lastSold;
	}
	
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public int getxFor() {
		return xFor;
	}
	public void setxFor(int xFor) {
		this.xFor = xFor;
	}
	
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	public String getMinLastSold() {
		return minLastSold;
	}
	public void setMinLastSold(String minLastSold) {
		this.minLastSold = minLastSold;
	}
	
	public String getMaxLastSold() {
		return maxLastSold;
	}
	public void setMaxLastSold(String maxLastSold) {
		this.maxLastSold = maxLastSold;
	}
	
	public String getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(String priceMin) {
		this.priceMin = priceMin;
	}
	
	public String getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(String priceMax) {
		this.priceMax = priceMax;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
