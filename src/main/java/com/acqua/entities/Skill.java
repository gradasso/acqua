package com.acqua.entities;

import org.springframework.data.annotation.Id;

public class Skill {

	@Id
	private String id;

	private Element element;

	private int grade;

	private double yearOfExperience;

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

}
