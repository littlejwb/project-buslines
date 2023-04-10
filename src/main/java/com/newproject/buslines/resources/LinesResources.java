package com.newproject.buslines.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.buslines.entities.Lines;
import com.newproject.buslines.services.LinesService;

@RestController
@RequestMapping(value = "/lines")
public class LinesResources {

	private LinesService linesService;

	public LinesResources(LinesService linesService) {
		this.linesService = linesService;
	}	
	
	@GetMapping
	public ResponseEntity<List<Lines>> findAll(){
		List<Lines> list = linesService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{departure}/{endpoint}")
    public List<Lines> getLinesByDepartureAndEndpoint(@PathVariable String departure, @PathVariable String endpoint) {
        return linesService.findByDepartureAndEndpoint(departure, endpoint);
	}	
}
