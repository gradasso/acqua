package com.acqua.modules.element;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.acqua.entities.Element;
import com.acqua.rest.CrudWs;
import com.acqua.rest.requests.DeleteRequest;
import com.acqua.rest.responses.BaseResponse;
import com.acqua.rest.responses.ListResponse;
import com.acqua.rest.responses.ReadResponse;
import com.acqua.services.ElementService;



/**
 * Component for implement the business logic of the Element's API
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
@Component
public class ApiElementImpl implements CrudWs<Element> {
	
	
	//Logger
	private static final Logger log = LoggerFactory.getLogger(ApiElementImpl.class);
	
	
	@Autowired
	private ElementService elementService;

	
	
	/**
	 * Implementation of service for create a new {@link Element}
	 * 
	 * @param {@link Element} json
	 */
	@Override
	public BaseResponse save(Element element) {
		log.debug("saving a new element");
		
		elementService.save(element);
		
		log.debug("saved new element with id {}", element.getId());
		
		return new BaseResponse(HttpStatus.CREATED.toString(), 
				"New resource has been created", 
				"saved new element '"+element.getDescription()+"' with id '"+element.getId()+"'");
	}

	

	
	/**
	 * Implementation of service for get a {@link Element} by its id
	 * 
	 * @param {@link String} unique id
	 * 
	 * @return {@link ReadResponse<Element>} response
	 */
	@Override
	public ReadResponse<Element> read(String id) {
		
		log.debug("request element with id '{}'", id);
		
		ReadResponse<Element> response = new ReadResponse<>();
		
		if (StringUtils.isNotBlank(id)) {
			
			Element element = elementService.findById(id);
			
			if (element != null) {
				log.debug("Element with id '{}' exist", id);
				response.setItem(element);
				response.setStatusCode(HttpStatus.OK.toString());
				response.setMessage("Element with id "+id+" exist");
				response.setStatusMessage("OK");
			} else {
				log.debug("Element with id '{}' not found", id);
				response.setStatusCode(HttpStatus.NOT_FOUND.toString());
				response.setMessage("Element with id "+id+" not found");
			}
		} else {
			log.debug("Parameter ID is not present");
			response.setStatusCode(HttpStatus.BAD_REQUEST.toString());
			response.setStatusMessage("ID is mandatory");
			response.setMessage("ID parameter is mandatory");
		}
		
		return response;
	}

	
	
	/**
	 * Implementation of a service that update an {@link Element} object
	 * 
	 * @param {@link Element} to update
	 * 
	 * @return {@link BaseResponse} response
	 */
	@Override
	public BaseResponse update(Element element) {
		
		BaseResponse response = new BaseResponse();
		
		log.debug("updating element with id {}", element.getId());
		
		elementService.save(element);
		
		response.setStatusCode(HttpStatus.OK.toString());
		response.setMessage("Element with id "+element.getId()+" updated");
		response.setStatusMessage("OK");
		
		log.debug("update element with id {}", element.getId());
		
		return response;
	}

	
	
	/**
	 * Implementation of a service for delete an {@link Element}
	 * 
	 * @param deleteRequest {@link DeleteRequest} request
	 * 
	 * @return {@link BaseResponse} response
	 */
	@Override
	public BaseResponse delete(DeleteRequest deleteRequest) {
		
		BaseResponse response = new BaseResponse();
		Element element = elementService.findById(deleteRequest.getId());
		
		if (element != null) {
			elementService.delete(element);
			
			response.setStatusCode(HttpStatus.OK.toString());
			response.setStatusMessage("OK");
			response.setMessage("Element with id "+deleteRequest.getId()+" deleted successfully");
		} else {
			response.setStatusCode(HttpStatus.NOT_FOUND.toString());
			response.setStatusMessage("Not found");
			response.setMessage("Element with id "+deleteRequest.getId()+" not found");
		}
		
		return response;
	}
	
	
	
	/**
	 * Implementation of a service that list all {@link Element} stored in database
	 * 
	 * @return {@link ListResponse<Element>} response
	 */
	@Override
	public ListResponse<Element> list() {
		
		ListResponse<Element> response = new ListResponse<>();
		List<Element> list = elementService.list();
		
		response.setItems(list);
		
		if (list.isEmpty()) {
			response.setMessage("Elements collections is empty");
			response.setStatusCode(HttpStatus.NO_CONTENT.toString());
			response.setStatusMessage("No content");
		} else {
			response.setMessage("Found "+list.size()+" elements");
			response.setStatusCode(HttpStatus.OK.toString());
			response.setStatusMessage("Ok");
		}
		
		return response;
	}

}
