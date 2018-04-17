package com.samirsantos.cursomc.services.exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException (String args) {
		super(args);
	}

	public ObjectNotFoundException (String msg, Throwable causa) {
		super(msg,causa);
	}
}
