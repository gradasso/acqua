package com.acqua.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acqua.entities.Employee;
import com.acqua.repositories.EmployeeRepository;



/**
 * Service layer for {@link Employee} object managment
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
@Service
public class EmployeeService {
	
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	
	/**
	 * Function that save the element passed as a parameter
	 * 
	 * @param element {@link Employee} to save
	 */
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	
	
	/**
	 * Function that find element by its id
	 * 
	 * @param id {@link String} unique id
	 * 
	 * @return {@link Employee} if exist, <code>null</code> otherwise
	 */
	public Employee findById(String id) {
		
		Employee result = null;
		Optional<Employee> element = employeeRepository.findById(id);
		
		if (element.isPresent())
			result = element.get();
		
		return result;
	}
	
	
	
	/**
	 * Procedure for delete an element
	 * 
	 * @param element {@link Employee} to delete
	 */
	public void delete(Employee employee) {
		employeeRepository.delete(employee);
	}

	
	
	/**
	 * Function for list all {@link Employee} stored in database
	 * 
	 * @return {@link List<Employee>} response
	 */
	public List<Employee> list() {
		return employeeRepository.findAll();
	}
}
