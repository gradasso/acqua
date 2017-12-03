package com.acqua.entities;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Category {

	@Id
	private String id;

	private String name;

	private List<Element> elements;

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

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

}
