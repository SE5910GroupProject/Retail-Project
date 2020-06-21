package com.example.retailstore.repositories.temp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.temp.Supplier;

//@Repository
public class SupplierRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
	public void insertSupplier(
			String companyName
			, String contactName
			, String contactDesignation
			, int phoneNumber
			, String address
			, String city
			, int zipCode
			, String country) {
    	String sql = "INSERT INTO suppliers VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    	
    	jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, companyName);
				ps.setString(2, contactName);
				ps.setString(3, contactDesignation);
				ps.setInt(4, phoneNumber);
				ps.setString(5, address);
				ps.setString(6, city);
				ps.setInt(7, zipCode);
				ps.setString(8, country);
				return ps.execute();
			}
    		
    	});
	}
	
	public List<Supplier> retrieveSuppliers() {
		String sql = "SELECT "
				+ "supplier_ID AS supplierID"
				+ ", company_name AS companyName"
				+ ", contact_name AS contactName"
				+ ", contact_designation AS contactDesignation"
				+ ", phone_number AS phoneNumber"
				+ ", address AS address"
				+ ", city AS city"
				+ ", zip_code AS zipCode"
				+ ", country AS country"
				+ " FROM suppliers";
		
		List<Supplier> suppliers = jdbcTemplate.queryForList(sql, Supplier.class);
		
		return suppliers;
	}
	
	public void updateSupplier(int supplierID
			, String companyName
			, String contactName
			, String contactDesignation
			, int phoneNumber
			, String address
			, String city
			, int zipCode
			, String country) {
		String sql = "UPDATE suppliers SET "
				+ " company_name = ?"
				+ ", contact_name = ?"
				+ ", contact_name = ?"
				+ ", contact_name = ?"
				+ ", contact_name = ?"
				+ ", contact_name = ?"
				+ ", contact_name = ?"
				+ " WHERE supplier_id = ?";
	
		jdbcTemplate.update(sql, companyName, contactName, contactDesignation, phoneNumber, address, city, zipCode, country, supplierID);
	
	}
	
	public void deleteSupplier(int supplierID) {
		String sql = "DELETE FROM suppliers WHERE supplier_id = ?";
		jdbcTemplate.update(sql, supplierID);
	}
	
}
