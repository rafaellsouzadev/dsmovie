package com.rafael.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.dsmovie.dto.MovieDTO;
import com.rafael.dsmovie.dto.ScoreDTO;
import com.rafael.dsmovie.services.ScoreService;

@RestController
@RequestMapping("/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		
		MovieDTO movieDto = scoreService.saveScore(dto);
				
		return movieDto;
	}

}
