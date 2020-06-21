package com.example.retailstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.Employee;

@Repository("employeesRepository")
public interface EmployeesRepository extends JpaRepository<Employee, Integer> {

}
