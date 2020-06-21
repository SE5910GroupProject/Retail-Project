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

import com.example.retailstore.model.temp.Employee;

//@Repository
public class EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
	public void insertEmployee(String name, String designation) {
    	String sql = "INSERT INTO employee VALUES(?, ?)";
    	
    	jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, name);
				ps.setString(2, designation);
				return ps.execute();
			}
    		
    	});
	}
	
	public List<Employee> retrieveEmployees() {
		String sql = "SELECT employee_ID AS employeeID , name AS name, designation as designation FROM employee";
		
		List<Employee> employees = jdbcTemplate.queryForList(sql, Employee.class);
		
		return employees;
	}
	
	public void updateEmployee(int employeeID, String name, String designation) {
		String sql = "UPDATE employee SET name = ?, designation = ? WHERE employee_id = ?";
	
		jdbcTemplate.update(sql, name, designation, employeeID);
	
	}
	
	public void deleteEmployee(int employeeID) {
		String sql = "DELETE FROM employee WHERE employee_id = ?";
		jdbcTemplate.update(sql, employeeID);
	}
	
}
