package net.heb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import net.heb.interfaces.IProductDao;
import net.heb.model.Product;

/**
 * Data Access Object for querying Product data.
 * @author Gareth
 *
 */
@Repository
public class ProductDao extends NamedParameterJdbcDaoSupport implements IProductDao {
	
	@Autowired private DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	public List<Product> setProducts(Product product) {
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource parms = new MapSqlParameterSource();
		
		sql.append("SELECT productID, ");
		sql.append("	description, ");
		sql.append("	convert(char(10), lastSold, 101) AS lastSold, ");
		sql.append("	shelfLife, ");
		sql.append("	department, ");
		sql.append("	price, ");
		sql.append("	unit, ");
		sql.append("	xFor, ");
		sql.append("	cost ");
		sql.append("FROM product ");
		
		return getNamedParameterJdbcTemplate().query(sql.toString(), parms, new ProductRowMapper());
	}
	
	public List<Product> filterProducts(Product product) {
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource parms = new MapSqlParameterSource();
		
		String productID = product.getProductID();
		String description = StringUtils.trimToNull(product.getDescription()) == null ? "%" : product.getDescription();
		String department = StringUtils.trimToNull(product.getDepartment()) == null ? "%" : product.getDepartment();
		String shelfLife = StringUtils.trimToNull(product.getShelfLife()) == null ? "%" : product.getShelfLife();
		String priceMin = StringUtils.trimToEmpty(product.getPriceMin());
		String priceMax = StringUtils.trimToEmpty(product.getPriceMax());
		
		
		parms.addValue("productID", productID);
		parms.addValue("description", description);
		parms.addValue("department", department);
		parms.addValue("shelfLife", shelfLife);
		
		/* Checking to see if valid positive string representation of a decimal, if it's not set value to null, 
		 * will not be included in below sql when null. */
		if(priceMin.replace(".",  "").chars().allMatch( Character::isDigit ) && priceMin.length() > 0) {
			parms.addValue("priceMin", priceMin);
		} else {
			priceMin = null;
		}
		
		if(priceMax.replace(".",  "").chars().allMatch( Character::isDigit ) && priceMax.length() > 0) {
			parms.addValue("priceMax", priceMax);
		} else {
			priceMax = null;
		}
		
		sql.append("SELECT productID, ");
		sql.append("	description, ");
		sql.append("	convert(char(10), lastSold, 101) AS lastSold, ");
		sql.append("	shelfLife, ");
		sql.append("	department, ");
		sql.append("	price, ");
		sql.append("	unit, ");
		sql.append("	xFor, ");
		sql.append("	cost ");
		sql.append("FROM product ");
		sql.append("WHERE description LIKE :description ");
		sql.append("AND department LIKE :department ");
		sql.append("AND shelfLife LIKE :shelfLife ");
		sql.append(!StringUtils.trimToEmpty(product.getProductID()).equals("") ? ("AND  productID LIKE CAST(:productID AS INTEGER) ") : "");
		sql.append(priceMin != null ? "AND price >= :priceMin " : "");
		sql.append(priceMax != null ? "AND price <= :priceMax " : "");
		
		
		return getNamedParameterJdbcTemplate().query(sql.toString(), parms, new ProductRowMapper());
	}
	
	public class ProductRowMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product row = new Product();
			
			row.setProductID(rs.getString("productID"));
			row.setDescription(rs.getString("description"));
			row.setLastSold(rs.getString("lastSold"));
			row.setShelfLife(rs.getString("shelfLife"));
			row.setDepartment(rs.getString("department"));
			row.setPrice(rs.getBigDecimal("price"));
			row.setUnit(rs.getString("unit"));
			row.setxFor(rs.getInt("xFor"));
			row.setCost(rs.getBigDecimal("cost"));
			
			return row;
		}

	}
	
	
	public List<String> getListByFieldName(String fieldName) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT ");
		sql.append(fieldName);
		sql.append(" FROM product ");
		
		if(fieldName.equals("productID")) { 
			sql.append("ORDER BY productID");
		} 
		else if(fieldName.equals("description")) {
			sql.append("ORDER BY description");
		}
		else if(fieldName.equals("department")) {
			sql.append("ORDER BY department");
		}
		else if(fieldName.equals("shelfLife")) {
			sql.append("ORDER BY shelfLife");
		}
		
		MapSqlParameterSource parms = new MapSqlParameterSource();
		
		return getNamedParameterJdbcTemplate().queryForList(sql.toString(), parms, String.class);
	}
}
