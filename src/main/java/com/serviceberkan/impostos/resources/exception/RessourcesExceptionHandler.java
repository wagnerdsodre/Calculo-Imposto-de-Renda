package com.serviceberkan.impostos.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.serviceberkan.impostos.exception.ObjNotFoundException;

@ControllerAdvice
public class RessourcesExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StandardError> ObjNotFound(ObjNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado",
				e.getMessage(), request.getRequestURI());
		return (ResponseEntity<StandardError>) ResponseEntity.status(status).body(error);
	}

}
