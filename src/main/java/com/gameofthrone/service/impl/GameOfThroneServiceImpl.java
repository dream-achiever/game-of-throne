package com.gameofthrone.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gameofthrone.model.Character;
import com.gameofthrone.service.GameOfThroneService;
import com.gameofthrone.utils.GameOfThroneUtils;

@Service
public class GameOfThroneServiceImpl implements GameOfThroneService{
	
	@Autowired
	GameOfThroneUtils gameOfThroneUtils;
	
	@Override
	public Character[] findAllCharacters(){
		
		Character[] characters = gameOfThroneUtils.getCharacters();
				
		return characters;
	}

	@Override
	public List<Character> findByTitle(String title) {
		
		Character[] characters = gameOfThroneUtils.getCharacters();
		
		List<Character> matchedCharacters = new ArrayList<>();
		
		for(Character character : characters) {
			
			String charTitle = character.getTitle().toLowerCase();
			
			if(charTitle.contains(title.toLowerCase())) {
				matchedCharacters.add(character);
			}
		}
		
		return matchedCharacters;
	}

}
