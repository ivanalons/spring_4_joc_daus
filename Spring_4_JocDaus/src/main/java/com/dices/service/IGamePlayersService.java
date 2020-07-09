package com.dices.service;

import java.util.List;

import com.dices.dto.GamePlayers;
import com.dices.dto.Player;

public interface IGamePlayersService {

	public GamePlayers addPlayerToGame(Long idGame, Long idPlayer);
	
	public List<GamePlayers> listAllGamePlayers();
	
	public List<GamePlayers> listGamePlayersByGame(Long idGame);
	
	public GamePlayers setGameWinner(Long idGame, Long idPlayer);
	
	public List<Player> listPlayersByGame(Long idGame);

	
}
