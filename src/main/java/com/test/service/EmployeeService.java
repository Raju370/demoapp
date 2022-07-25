package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.domain.Employee;
import com.test.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	
	public List<Employee> getEmployees(){
		return repository.findAll();
	}
	
}
