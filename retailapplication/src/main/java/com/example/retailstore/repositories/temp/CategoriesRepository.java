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

import com.example.retailstore.model.temp.Category;

//@Repository
public class CategoriesRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
	public void insertCategory(String categoryName, String description) {
    	String sql = "INSERT INTO categories VALUES(?, ?)";
    	
    	jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, categoryName);
				ps.setString(2, description);
				return ps.execute();
			}
    		
    	});
	}
	
	public List<Category> retrieveCategories() {
		String sql = "SELECT category_ID AS categoryID , category_name AS categoryName, description AS description FROM categories";
		
		List<Category> categories = jdbcTemplate.queryForList(sql, Category.class);
		
		return categories;
	}
	
	public void updateCategory(int categoryID, String categoryName, String description) {
		String sql = "UPDATE categories SET category_name = ?, description = ? WHERE category_id = ?";
	
		jdbcTemplate.update(sql, categoryName, description, categoryID);
	
	}
	
	public void deleteCategory(int categoryID) {
		String sql = "DELETE FROM categories WHERE category_id = ?";
		jdbcTemplate.update(sql, categoryID);
	}
	
}
