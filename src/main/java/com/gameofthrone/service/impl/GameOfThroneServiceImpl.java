package com.gameofthrone.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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

	@Override
	public Character[] findCharactersByNewest() {
		
		Character[] characters = gameOfThroneUtils.getCharacters();
		
		sortCharactersById(characters);
		
		return characters;
	}

	private void sortCharactersById(Character[] characterList) {
		
		Arrays.sort(characterList,new Comparator<Character>() {
			public int compare(Character a,Character b) {
				
				return b.getId().intValue() - a.getId().intValue();
			} 
		});
	}

	@Override
	public Character[] findCharactersByOrderedName(String orderBy) {
		
		Character[] characters = gameOfThroneUtils.getCharacters();
		
		sortCharactersByName(characters,orderBy);
		
		return characters;
	}
	
	private void sortCharactersByName(Character[] characters,String orderBy) {
		
		Arrays.sort(characters,new Comparator<Character>() {
			
			public int compare(Character a, Character b) {
				if(orderBy.equalsIgnoreCase("asc")) {
					return a.getFullName().compareToIgnoreCase(b.getFullName());
				}
				else {
					return b.getFullName().compareToIgnoreCase(a.getFullName());
				}
			}
			
		});
		
	}
	
}
