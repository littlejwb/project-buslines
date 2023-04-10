package com.newproject.buslines.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.newproject.buslines.services.exception.RouteNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RouteExceptionHandler {

	@ExceptionHandler(RouteNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(RouteNotFoundException e, HttpServletRequest request){
		String error = "Route not found.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
