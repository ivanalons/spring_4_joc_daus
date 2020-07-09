package com.dices.service;

import java.util.List;

import com.dices.dto.Player;

public interface IPlayerService {

	public Player createPlayer(Player player);
	
	public Player updatePlayer(Long playerId, Player player);
	
	public List<Player> listAllPlayers();
	
}
