package com.acqua.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acqua.entities.Employee;
import com.acqua.entities.Skill;
import com.acqua.repositories.EmployeeRepository;
import com.acqua.repositories.SkillRepository;



/**
 * Service layer for {@link Skill} object managment
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
@Service
public class SkillService {
	
	
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	
	/**
	 * Function that save the skill passed as a parameter
	 * 
	 * @param element {@link Skill} to save
	 */
	public void save(Skill skill) {
		skillRepository.save(skill);
	}
	
	
	
	/**
	 * Function that find skill by its id
	 * 
	 * @param id {@link String} unique id
	 * 
	 * @return {@link Skill} if exist, <code>null</code> otherwise
	 */
	public Skill findById(String id) {
		
		Skill result = null;
		Optional<Skill> category = skillRepository.findById(id);
		
		if (category.isPresent())
			result = category.get();
		
		return result;
	}
	
	
	
	/**
	 * Procedure for delete a skill
	 * 
	 * @param category {@link Skill} to delete
	 */
	public void delete(Skill skill) {
		skillRepository.delete(skill);
	}

	
	
	/**
	 * Function for list all {@link Skill} stored in database
	 * 
	 * @return {@link List<Skill>} response
	 */
	public List<Skill> list() {
		return skillRepository.findAll();
	}
	
	
	
	/**
	 * Function to associate an {@link Skill} to a container object 
	 * 
	 * @param id {@link String} unique identifier of container object
	 * 
	 * @param element {@link Skill} object to associate to a container
	 * 
	 * @return {@link Employee} updated container
	 */
	public Employee associate(String id, Skill skill) {
		Employee result = null;
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if (employee.isPresent()) {
			result = associate(employee.get(), skill);
		}
		
		return result;
	}
	
	
	
	/**
	 * Function to associate a {@link Skill} to a {@link Employee} object 
	 * 
	 * @param category {@link Employee} container object
	 * 
	 * @param element {@link Skill} object to associate to a container
	 * 
	 * @return {@link Employee} updated container
	 */
	public Employee associate(Employee employee, Skill skill) {
		Employee result = employee;
		
		List<Skill> skills = result.getSkills();
		
		if (CollectionUtils.isNotEmpty(skills)) {
			skills.add(skill);
		} else {
			skills = Arrays.asList(skill);
		}
		
		return result;
	}
}
