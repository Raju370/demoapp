package com.test;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

import com.test.main.SampleApplication;

@SpringBootTest
@ContextConfiguration(classes={SampleApplication.class})
@EnableJpaRepositories(basePackages = {"com.test.*"})
@EntityScan("com.test")

public class FacultyRepositoryTest {
	
//	@Autowired
//	private FacultyRepository facultyRepository;
	
	
	

}


/*
 *	@Autowired
	private EmployeeRepository repository;
		
	@Test
	public void testGetAllEmployees() {
	List<Employee> employees = repository.findAll();
		
	assertEquals(5, employees.size());
	assertThat(employees).extracting("emp_fname").contains("Mia", "Noah", "James", "Ava", "John"); 
 * 
 * 
 */