package com.gameofthrone.service;

import java.util.ArrayList;
import java.util.List;

import com.gameofthrone.model.Character;

public interface GameOfThroneService {
	
	public Character[] findAllCharacters();
	
	public List<Character> findByTitle(String title);

}
