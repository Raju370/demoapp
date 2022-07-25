package com.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.test.domain.Employee;
import com.test.main.SampleApplication;
import com.test.repository.EmployeeRepository;

@SpringBootTest
@ContextConfiguration(classes={SampleApplication.class})
@EnableJpaRepositories(basePackages = {"com.test.*"})
@EntityScan("com.test.*")
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    // JUnit test for saveEmployee
    @Test
    @Order(1)
    @Transactional
    @Rollback(value = true)
    public void saveEmployeeTest(){

        Employee employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail.com")
                .build();
               
        Employee savedEmployee = employeeRepository.save(employee);

        assertThat(savedEmployee.getId()).isGreaterThan(0);
        
    }
    
    // JUnit test for getEmployee

    @Test
    @Order(2)
    @Transactional
    @Rollback(value = true)
    public void getEmployeeTest(){
    	
    	Employee employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail.com")
                .build();

    	Employee savedEmployee = employeeRepository.save(employee);	
    	
        Employee result = employeeRepository.findById(savedEmployee.getId()).get();

        assertThat(result).isNotNull();
        assertEquals(employee.getFirstName(), result.getFirstName());
        assertEquals(employee.getLastName(), result.getLastName());
        assertEquals(employee.getEmail(),result.getEmail());
        
    }

    // JUnit test for getListOfEmployeesTest
    @Test
    @Order(3)
    @Transactional
    @Rollback(value = true)
    public void getListOfEmployeesTest(){
    	
    	Employee employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail.com")
                .build();

    	Employee savedEmployee = employeeRepository.save(employee);
    	    	
        Employee result = employeeRepository.findById(savedEmployee.getId()).get();

        List<Employee> employees = employeeRepository.findAll();

        //assertEquals(employees.size(), result.size());
        assertThat(employees.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Transactional
    @Rollback(value = true)
    public void updateEmployeeTest(){
    	
    	Employee employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail.com")
                .build();

    	Employee savedEmployee = employeeRepository.save(employee);
    	    	
        Employee result = employeeRepository.findById(savedEmployee.getId()).get();

        List<Employee> employees = employeeRepository.findAll();
        
        //assert.notEquals("ramesh@gmail.com", employeeUpdated.getEmail());
                
        assertEquals("ramesh@gmail.com",savedEmployee.getEmail());
                     
        employee.setEmail("ram@gmail.com");

        Employee employeeUpdated =  employeeRepository.save(employee);
                      
       assertEquals("ram@gmail.com", employeeUpdated.getEmail());
       
       //assertThat(employeeUpdated.getEmail()).isEqualTo("ram@gmail.com");

    }

    @Test
    @Order(5)
    @Transactional
    @Rollback(value = true)
    
   
    public void deleteEmployeeTest(){
    	    	       	
        	Employee employee = Employee.builder()
                    .firstName("Ramesh")
                    .lastName("Fadatare")
                    .email("ramesh@gmail.com")
                    .build();

        	Employee savedEmployee = employeeRepository.save(employee);
        	    	
            Employee result = employeeRepository.findById(savedEmployee.getId()).get();


        //Employee employee = employeeRepository.findById().get();

        employeeRepository.delete(result);

        //employeeRepository.deleteById(1L);

        Employee employee1 = null;

        Optional<Employee> optionalEmployee = employeeRepository.findByEmail("ram@gmail.com");

        if(optionalEmployee.isPresent()){
            employee1 = optionalEmployee.get();
        }

        assertThat(employee1).isNull();
    }

}









/*
 * 
 * import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

import com.test.domain.Employee;
import com.test.main.SampleApplication;
import com.test.repository.EmployeeRepository;

import java.util.Optional;

@SpringBootTest
@ContextConfiguration(classes={SampleApplication.class})
@EnableJpaRepositories(basePackages = {"com.test.*"})
@EntityScan("com.test.*")

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTest {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
		
	@Test
	public void testGetAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		
		assertEquals(5, employees.size());
		assertThat(employees).extracting("emp_fname").contains("Mia", "Noah", "James", "Ava", "John");
		
		assertThat(employees).extracting("emp_lname").contains("Smith", "Clark", "Rodriguez", "Gracia", "Luther");
		
		assertThat(employees).extracting("emp_location").contains("New York", "Florida", "Chicago", "Houston", "Los Angeles");
				
		}
	
	/*
     * @Test annotation tells the JUnit that the method associated with this annotation is can be run as a test case.
     * JUnit initially creates a fresh instance/Object for the class and then invokes the annotated method. 
     * Any exceptions thrown by the test will be reported by JUnit as a failure.
     */
	
	