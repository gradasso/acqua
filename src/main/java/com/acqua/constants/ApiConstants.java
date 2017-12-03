package com.acqua.constants;

import com.acqua.entities.Element;

/**
 * Centralized constants only for API
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
public class ApiConstants {
	
	
	/**
	 * Base context root name for API
	 */
	public static final String API_CONTEXT_ROOT = "/api";
	
	
	
	/**
	 * Version number of API
	 */
	public static final String API_VERSION_1 = "/v1";
	
	
	
	/**
	 * Path for {@link Element} resource
	 */
	public static final String API_PATH_ELEMENT = "/element";
	
	
	
	/**
	 * Full path for {@link Element} resource v.1
	 */
	public static final String API_V1_SKILL = API_CONTEXT_ROOT + API_VERSION_1 + API_PATH_ELEMENT;
	
	
	
	/**
	 * Protector from the constructor
	 */
	private ApiConstants() {
		throw new IllegalAccessError("Constants class");
	}

}
