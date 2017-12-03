package com.acqua.rest;

import com.acqua.rest.requests.DeleteRequest;
import com.acqua.rest.responses.BaseResponse;
import com.acqua.rest.responses.ListResponse;
import com.acqua.rest.responses.ReadResponse;



/**
 * Interface to define API standard for {@link T} object
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
public interface CrudWs<T> {

	
	
	/**
	 * Function to save new {@link T}
	 * 
	 * @param t {@link T} to store in database
	 * 
	 * @return {@link ReadResponse<T>} base response
	 */
	BaseResponse save(T t);
	
	
	
	/**
	 * Function to get a {@link T} by its id
	 * 
	 * @param {@link String} unique id
	 * 
	 * @return {@link ReadResponse<T>} base response
	 */
	ReadResponse<T> read(String id);
	
	
	
	/**
	 * Function to update a {@link T}
	 * 
	 * @param t {@link T} to update
	 *  
	 * @return {@link ReadResponse<T>} base response
	 */
	BaseResponse update(T t);
	
	
	
	/**
	 * Function to delete a {@link T}
	 * 
	 * @param request {@link DeleteRequest} request
	 *  
	 * @return {@link ReadResponse<T>} base response
	 */
	BaseResponse delete(DeleteRequest deleteRequest);
	
	
	
	/**
	 * Function to list all {@link T}
	 * 
	 * @return {@link ListResponse<T>} list of all {@link T} stored in the database
	 */
	ListResponse<T> list();
	
	
	
}
