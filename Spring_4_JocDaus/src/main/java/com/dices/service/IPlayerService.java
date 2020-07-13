package com.dices.service;

import java.util.List;

import com.dices.dto.Player;
/**
 * Operacions sobre la taula PLAYERS
 * @author Ivan
 *
 */
public interface IPlayerService {

	//Crea un nou jugador
	public Player createPlayer(Player player);
	
	//Modifica el nom del jugador amb id "playersId" passat pel parametre player
	public Player updatePlayer(Long playerId, Player player);

	//Retorna un llistat de tots els jugadors
	public List<Player> listAllPlayers();
	
}
