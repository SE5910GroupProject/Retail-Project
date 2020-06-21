package com.example.retailstore.repositories.temp;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.temp.Product;

//@Repository
public class ProductsRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
	public void insertProduct(
			  int supplierID
			, int categoryID
			, String productName
			, BigDecimal unitPrice
			, String quantityPerUnit
			, int unitsInStock
			, int discountPercent
			, int productStatus) {
		
    	String sql = "INSERT INTO products VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    	
    	jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, supplierID);
				ps.setInt(2, categoryID);
				ps.setString(3, productName);
				ps.setBigDecimal(4, unitPrice);
				ps.setString(5, quantityPerUnit);
				ps.setInt(6, unitsInStock);
				ps.setInt(7, discountPercent);
				ps.setInt(8, productStatus);
				return ps.execute();
			}
    		
    	});
	}
	
	public List<Product> retrieveProducts() {
		String sql = "SELECT "
				+ "product_id AS productID"
				+ ", supplier_id AS supplierID"
				+ ", category_id AS categoryID"
				+ ", product_name AS productName"
				+ ", unit_price as unitPrice"
				+ ", quantity_per_unit as quantityPerUnit"
				+ ", units_in_stock as unitsInStock"
				+ ", discount_percent as discountPercent"
				+ ", product_status as product_status"
				+ " FROM products";
		
		List<Product> products = jdbcTemplate.queryForList(sql, Product.class);
		
		return products;
	}
	
	public void updateProduct(
			int productID
			, int supplierID
			, int categoryID
			, String productName
			, BigDecimal unitPrice
			, String quantityPerUnit
			, int unitsInStock
			, int discountPercent
			, int productStatus) {
		
		String sql = "UPDATE products SET "
				+ ", supplier_id = ?"
				+ ", category_id = ?"
				+ ", product_name = ?"
				+ ", unit_price = ?"
				+ ", quantity_per_unit = ?"
				+ ", units_in_stock = ?"
				+ ", discount_percent = ?"
				+ ", product_status = ?"
				+ " WHERE product_id = ?";
	
		jdbcTemplate.update(sql, supplierID, categoryID, productName, unitPrice, quantityPerUnit, unitsInStock, discountPercent, productStatus, productID);
	
	}
	
	public void deleteProduct(int productID) {
		String sql = "DELETE FROM products WHERE product_id = ?";
		jdbcTemplate.update(sql, productID);
	}
	
}
