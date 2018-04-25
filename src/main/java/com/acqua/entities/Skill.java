package com.acqua.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.acqua.constants.DatabaseConstants;



/**
 * Skill entity
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
@Document(collection=DatabaseConstants.COLLECTION_SKILLS)
public class Skill {

	@Id
	private String id;

	private Element element;

	private int grade;

	private double yearOfExperience;
	
	private String note;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public double getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(double yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
