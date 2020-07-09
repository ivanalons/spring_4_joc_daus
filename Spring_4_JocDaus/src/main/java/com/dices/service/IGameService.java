package com.dices.service;

import java.util.List;

import com.dices.dto.Game;

public interface IGameService {

	public Game createGame(Game game);
	
	public List<Game> listAllGames();
	
}