package com.rafael.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.dsmovie.dto.MovieDTO;
import com.rafael.dsmovie.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public Page<MovieDTO> findAll(Pageable pageabe) {
		return service.findAll(pageabe);
	}
	
	@GetMapping("/{id}")
	public MovieDTO findById(@PathVariable Long id) {
		return service.find(id);
	}

}
