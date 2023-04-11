package com.newproject.buslines.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.newproject.buslines.entities.Lines;
import com.newproject.buslines.repositories.LinesRepository;
import com.newproject.buslines.services.exception.RouteNotFoundException;

@Service
public class LinesService {
	
	private LinesRepository linesRepository;

	public LinesService(LinesRepository linesRepository) {
		this.linesRepository = linesRepository;
	}
	
	public List<Lines> findAll(){
		return linesRepository.findAll();
	}
	
    public List<Lines> findByDepartureAndEndpoint(String departure, String endpoint) {
    	List<Lines> routes = linesRepository.findByDepartureAndEndpoint(departure, endpoint);
    	if (routes.isEmpty()) {
    		throw new RouteNotFoundException(departure, endpoint);
    	}
    	return routes;
	}
}