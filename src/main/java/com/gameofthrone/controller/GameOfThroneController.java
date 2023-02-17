package com.gameofthrone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gameofthrone.model.Character;
import com.gameofthrone.service.GameOfThroneService;

@RestController
@RequestMapping("/api")
public class GameOfThroneController {
	
	@Autowired
	GameOfThroneService gameOfThroneService;
	
	@GetMapping("/getCharacters")
	public Character[] getCharacters() {
		
		return gameOfThroneService.findAllCharacters();
	}
	
	@PostMapping("/title")
	public List<Character> getCharactersByTitle(@RequestParam("title") String title) {
		
		return gameOfThroneService.findByTitle(title);
	}
	
	@GetMapping("/newest")
	public Character[] getNewestCharacters() {
		
		return gameOfThroneService.findCharactersByNewest();
	}
	
	@PostMapping("/orderByName")
	public Character[] getOrderByNameCharacters(@RequestParam("orderBy") String orderBy) {
		
		return gameOfThroneService.findCharactersByOrderedName(orderBy);
	}

}
