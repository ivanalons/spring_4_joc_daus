package com.dices.service;

import java.util.List;
import java.util.Map;

import com.dices.view.PlayerView;

/**
 * Operacions estadistiques
 * 
 * @author Ivan
 *
 */
public interface IStatisticsService {

	// Retorna un llistat amb tots els jugadors del sistema, indicant per a cada jugador 
	// el seu percentatge d'exit entre totes les tirades que ha realitzat
	public List<PlayerView> listPlayersStatistics();
	
	// Retorna un llistat amb tots els jugadors del sistema, indicant per a cada jugador 
	// el seu percentatge d'exit entre totes les tirades que ha realitzat
	// Es mostren de manera ordenada començant pel millor jugador i acabant per pitjor jugador
	public List<PlayerView> listPlayersRanking();

	// Retorna el percentatge d'exit mig del sistema (entre tots els jugador del sistema)
	public Map<String,Double> getGlobalAverageSuccessRate();
	
	// Retorna el millor jugador (el que te millor percentatge d'exit)
	public PlayerView getBestPlayer();
	
	// Retorna el pitjor jugador (el que te pitjor percentatge d'exit)
	public PlayerView getWorsePlayer();

}
