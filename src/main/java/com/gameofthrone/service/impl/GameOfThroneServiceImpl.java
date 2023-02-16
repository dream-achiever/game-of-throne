package com.gameofthrone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gameofthrone.model.Character;
import com.gameofthrone.service.GameOfThroneService;

@Service
public class GameOfThroneServiceImpl implements GameOfThroneService{
	
	@Value("${got.characters.url}")
	private String gotCharactersApiUrl;
	
	public Character[] findAllCharacters(){
		
		RestTemplate restTemplate = new RestTemplate();
		
		Character[] characters = restTemplate.getForObject(gotCharactersApiUrl, Character[].class);
				
		return characters;
	}

}
