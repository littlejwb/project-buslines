package com.newproject.buslines.services.exception;

public class RouteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RouteNotFoundException(String departure, String endpoint) {
		super("Rota " + departure + "-" + endpoint + " não encontrada. Refaça sua busca.");
	}
}
