package com.acqua.entities;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.acqua.constants.DatabaseConstants;



/**
 * Entity that represents the user.
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
@Document(collection = DatabaseConstants.COLLECTION_USERS)
public class User {
	
	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	@NotNull
	@Indexed
    private String username;
    
	@NotNull
    private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    

}
