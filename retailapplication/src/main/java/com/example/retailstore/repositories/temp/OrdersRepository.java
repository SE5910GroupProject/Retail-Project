package com.example.retailstore.repositories.temp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.temp.Order;

//@Repository
public class OrdersRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    //TODO: Figure this out
	public void insertOrder(int customerID, int userID, Date purchaseDate) {
    	String sql = "INSERT INTO orders VALUES(?, ?, ?)";
    	
    	jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, customerID);
				ps.setInt(2, userID);
				ps.setObject(3, purchaseDate);
				return ps.execute();
			}
    		
    	});
	}
	
	public List<Order> retrieveOrders() {
		String sql = "SELECT "
				+ "order_ID AS orderID"
				+ ", customer_id as customerID"
				+ ", user_id as userID"
				+ ", purchase_date as purchaseDate"
				+ " FROM orders";
		
		List<Order> orders = jdbcTemplate.queryForList(sql, Order.class);
		
		return orders;
	}
	
	public void updateOrder(int orderID, int customerID, int userID, Date purchaseDate) {
		String sql = "UPDATE orders SET customer_id = ?, user_id = ?, purchase_date = ? WHERE order_id = ?";
	
		jdbcTemplate.update(sql, customerID, userID, purchaseDate, orderID);
	
	}
	
	public void deleteOrder(int orderID) {
		String sql = "DELETE FROM orders WHERE order_id = ?";
		jdbcTemplate.update(sql, orderID);
	}
	
}
