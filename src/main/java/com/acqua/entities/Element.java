package com.acqua.entities;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.acqua.constants.DatabaseConstants;



/**
 * Entity that represents the element of a category.
 * For example: Java, Scala, Ruby etc etc...
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
@Document(collection = DatabaseConstants.COLLECTION_ELEMENTS)
public class Element {

	@Id
	private String id;

	@NotNull
	private String name;
	
	private String description;
	
	private String version;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}


}
