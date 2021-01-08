package com.mouzetech.service.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException() {
		super("Nenhum resultado encontrado para este ID");
	}
	
}
