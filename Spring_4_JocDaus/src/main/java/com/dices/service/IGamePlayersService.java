package com.dices.service;

import java.util.List;


import com.dices.dto.GamePlayers;
import com.dices.dto.Player;

public interface IGamePlayersService {

	public GamePlayers addPlayersToGame(Long idGame, Player player);
	
	public List<Player> listGamePlayers(Long idGame);
	
	public GamePlayers setGameWinner(Long idGame, Long idPlayer);
	
}
