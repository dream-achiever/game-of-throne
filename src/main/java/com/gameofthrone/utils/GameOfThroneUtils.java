package com.gameofthrone.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.gameofthrone.model.Character;

@Component
public class GameOfThroneUtils {
	
	@Value("${got.characters.url}")
	private String gotCharactersApiUrl;
	
	public Character[] getCharacters() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Character[] characters = restTemplate.getForObject(gotCharactersApiUrl, Character[].class);
		
		return characters;
	}

}
