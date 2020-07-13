package com.dices.service;

import java.util.List;

import com.dices.dto.Toss;

/**
 * Operacions sobre les taules TOSS(tirada) i DICES(daus)
 * @author Ivan
 *
 */
public interface ITossService {

	// Realitza un nova tirada de daus del jugador "playerId" a la partida "gameId"
	// Crea una nova instancia a la taula TOSS i una altra a la taula DICES amb el resultat de
    // la tirada de daus	
	public Toss createToss(Long gameId, Long playerId);
	
	// Retorna totes les tirades de daus del sistema
	public List<Toss> listAllTosses();
	
	//Retorna totes les tirades de daus de la partida amb id "gameId"
	public List<Toss> listTossesByGame(Long gameId);
	
	//Retorna totes les tirades de daus del jugador amb id "playerId" a totes les seves partides
	public List<Toss> listTossesByPlayer(Long playerId);
	
	//Esborra totes les tirades de daus del jugador amb id "playerId" a la partida amb id "gameId"
	public void deleteAllPlayerTossesByGame(Long gameId, Long playerId);

}
