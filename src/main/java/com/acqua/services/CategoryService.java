package com.acqua.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acqua.entities.Category;
import com.acqua.repositories.CategoryRepository;



/**
 * Service layer for {@link Category} object managment
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
@Service
public class CategoryService {
	
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	
	/**
	 * Function that save the category passed as a parameter
	 * 
	 * @param element {@link Category} to save
	 */
	public void save(Category category) {
		categoryRepository.save(category);
	}
	
	
	
	/**
	 * Function that find category by its id
	 * 
	 * @param id {@link String} unique id
	 * 
	 * @return {@link Category} if exist, <code>null</code> otherwise
	 */
	public Category findById(String id) {
		
		Category result = null;
		Optional<Category> category = categoryRepository.findById(id);
		
		if (category.isPresent())
			result = category.get();
		
		return result;
	}
	
	
	
	/**
	 * Procedure for delete a category
	 * 
	 * @param category {@link Category} to delete
	 */
	public void delete(Category category) {
		categoryRepository.delete(category);
	}

	
	
	/**
	 * Function for list all {@link Category} stored in database
	 * 
	 * @return {@link List<Category>} response
	 */
	public List<Category> list() {
		return categoryRepository.findAll();
	}
}
