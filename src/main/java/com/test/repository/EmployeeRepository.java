package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.domain.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);
}



/*
 * 
 * import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.domain.Employee;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	 Optional<Employee> findByEmail(String email);

}
 * 
 * */

