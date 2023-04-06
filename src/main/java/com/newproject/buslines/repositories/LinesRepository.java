package com.newproject.buslines.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newproject.buslines.entities.Lines;

@Repository
public interface LinesRepository extends JpaRepository<Lines, Long> {

	List<Lines> findByDepartureAndEndpoint(String departure, String endpoint);
	
}
