package com.gameofthrone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gameofthrone.model.Character;
import com.gameofthrone.service.GameOfThroneService;

@RestController
@RequestMapping("/api")
public class GameOfThroneController {
	
	@Autowired
	GameOfThroneService gameOfThroneService;
	
	@GetMapping("/getGOTCharacters")
	public Character[] getGOTCharacters() {
		
		return gameOfThroneService.findAllCharacters();
	}

}
