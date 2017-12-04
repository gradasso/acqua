package com.acqua.category.element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.acqua.entities.Category;
import com.acqua.rest.CrudWs;
import com.acqua.rest.requests.DeleteRequest;
import com.acqua.rest.responses.BaseResponse;
import com.acqua.rest.responses.ListResponse;
import com.acqua.rest.responses.ReadResponse;
import com.acqua.services.CategoryService;



/**
 * Component for implement the business logic of the Category's API
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
@Component
public class ApiCategoryImpl implements CrudWs<Category> {
	
	
	
	//Logger
	private static final Logger log = LoggerFactory.getLogger(ApiCategoryImpl.class);
	
	
	@Autowired
	private CategoryService categoryService;
	
	

	@Override
	public ResponseEntity<BaseResponse> save(Category category) {
		log.debug("saving a new category");
		
		categoryService.save(category);
		
		log.debug("saved new category with id {}", category.getId());
		
		BaseResponse response = new BaseResponse(HttpStatus.CREATED.toString(), 
				"New resource has been created", 
				"saved new category '"+category.getName()+"' with id '"+category.getId()+"'");
		
		return new ResponseEntity<BaseResponse>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ReadResponse<Category>> read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<BaseResponse> update(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<BaseResponse> delete(DeleteRequest deleteRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ListResponse<Category>> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
