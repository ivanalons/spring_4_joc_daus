package com.dices.service;

import java.util.List;

import com.dices.dto.Game;
/**
 * Operacions sobre la taula GAMES
 * @author Ivan
 *
 */
public interface IGameService {

	//Crea una partida (taula games)
	public Game createGame(Game game);
	
	//Retorna un llistat amb totes les partides (taula games)
	public List<Game> listAllGames();
	
}