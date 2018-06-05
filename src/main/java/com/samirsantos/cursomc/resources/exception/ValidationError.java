package com.samirsantos.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);

	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldname, String messagem) {
		errors.add(new FieldMessage(fieldname, messagem));
	}

}