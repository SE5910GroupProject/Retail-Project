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

import com.example.retailstore.model.temp.OrderDetails;

//@Repository
public class OrderDetailsRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
	public void insertOrderDetails(int orderID, int productID, int quantity, BigDecimal unitPrice, BigDecimal discount) {
    	String sql = "INSERT INTO order_details VALUES(?, ?, ?, ?, ?)";
    	
    	jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, orderID);
				ps.setInt(2, productID);
				ps.setInt(3, quantity);
				ps.setBigDecimal(4, unitPrice);
				ps.setBigDecimal(5, discount);
				return ps.execute();
			}
    		
    	});
	}
	
	public List<OrderDetails> retrieveOrderDetails() {
		String sql = "SELECT "
				+ "  order_id AS orderID"
				+ ", productID AS product_id"
				+ ", quantity AS quantity"
				+ ", unit_price AS unitPrice"
				+ ", discount AS discount"
				+ " FROM order_details";
		
		List<OrderDetails> orderDetails = jdbcTemplate.queryForList(sql, OrderDetails.class);
		
		return orderDetails;
	}
	
	public void updateOrderDetails(int orderID, int productID, int quantity, BigDecimal unitPrice, BigDecimal discount) {
		String sql = "UPDATE order_details SET "
				+ ", quantity = ?"
				+ ", unit_price = ?"
				+ ", discount = ?"
				+ " WHERE "
				+ " order_id = ?"
				+ " AND "
				+ " product_id = ?";
	
		jdbcTemplate.update(sql, quantity, unitPrice, discount, orderID, productID);
	
	}
	
	public void deleteOrderDetails(int orderID, int productID) {
		String sql = "DELETE FROM order_details WHERE order_id = ? AND product_id = ?";
		jdbcTemplate.update(sql, orderID, productID);
	}
	
}
