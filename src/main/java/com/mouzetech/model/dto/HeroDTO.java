package com.mouzetech.model.dto;

import java.io.Serializable;

public class HeroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	
	public HeroDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}