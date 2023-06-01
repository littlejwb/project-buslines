package com.newproject.buslines.resources;

import java.util.List;

import com.newproject.buslines.resources.util.URL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.newproject.buslines.entities.Lines;
import com.newproject.buslines.services.LinesService;

@RestController
@CrossOrigin(origins = "*")
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
	public ResponseEntity<List<Lines>> linesByDepartureAndEndpoint(@PathVariable String departure, @PathVariable String endpoint) {
		String encodedDep = URL.decodeParam(departure);
		String encodedEnd = URL.decodeParam(endpoint);
		List<Lines> lines = linesService.findByDepartureAndEndpoint(encodedDep, encodedEnd);
		return ResponseEntity.ok().body(lines);
	}
}
