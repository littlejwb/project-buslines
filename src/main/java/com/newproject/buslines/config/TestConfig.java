package com.newproject.buslines.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.newproject.buslines.entities.Lines;
import com.newproject.buslines.repositories.LinesRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	private LinesRepository linesRepository;

	public TestConfig(LinesRepository linesRepository) {
		this.linesRepository = linesRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Lines line1 = new Lines(null, "Centro", "Rosa", "12h00", "Dias uteis");
		Lines line2 = new Lines(null, "Rosa", "Centro", "12h00", "Dias uteis");
		Lines line3 = new Lines(null, "Centro", "Rosa", "13h00", "Dias uteis");
		Lines line4 = new Lines(null, "Capão", "Centro", "13h30", "Dias úteis");
		
		linesRepository.saveAll(Arrays.asList(line1, line2, line3, line4));
		
	}
}
