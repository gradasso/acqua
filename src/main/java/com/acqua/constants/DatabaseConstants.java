package com.acqua.constants;

/**
 * Costants for database
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
public class DatabaseConstants {
	
	
	/**
	 * Collection prefix
	 */
	public static final String COLLECTION_PREFIX = "";
	
	
	
	/**
	 * Categories' collection
	 */
	public static final String COLLECTION_CATEGORIES = COLLECTION_PREFIX + "categories";

	
	
	/**
	 * Departments' collection
	 */
	public static final String COLLECTION_DEPARTMENTS = COLLECTION_PREFIX + "departments";

	
	
	/**
	 * Elements' collection
	 */
	public static final String COLLECTION_ELEMENTS = COLLECTION_PREFIX + "elements";

	
	
	/**
	 * Employees' collection
	 */
	public static final String COLLECTION_EMPLOYEES = COLLECTION_PREFIX + "employees";

	
	
	/**
	 * Skills' collection
	 */
	public static final String COLLECTION_SKILLS = COLLECTION_PREFIX + "skills";

	
	
	/**
	 * Users' collection
	 */
	public static final String COLLECTION_USERS = COLLECTION_PREFIX + "users";
	
	
	
	/**
	 * Protector from the constructor
	 */
	private DatabaseConstants() {
		throw new IllegalAccessError("Utility class");
	}

}
