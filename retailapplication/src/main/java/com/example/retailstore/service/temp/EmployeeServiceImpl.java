package com.example.retailstore.service.temp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retailstore.model.temp.Employee;
import com.example.retailstore.repositories.temp.EmployeeRepository;

//@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void insertEmployee(String employeeName, String designation) {
		employeeRepository.insertEmployee(employeeName, designation);
	}
	
	public List<Employee> retrieveEmployees() {
		
		List<Employee> employees = employeeRepository.retrieveEmployees();
		
		return employees;
	}
	
	public void updateEmployee(int employeeID, String name, String designation) {
		employeeRepository.updateEmployee(employeeID, name, designation);
	}
	
	public void deleteEmployee(int employeeID) {
		employeeRepository.deleteEmployee(employeeID);
	}
	
}
