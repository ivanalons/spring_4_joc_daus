package com.dices.service;

import java.util.List;

import com.dices.dto.GamePlayers;
import com.dices.dto.Player;

/**
 * Operacions sobre la taula GAMES_PLAYERS
 * @author Ivan
 *
 */
public interface IGamePlayersService {

	// Afegeix el jugador amb id "idPlayer" a la partida amb id "idGames"
	// (Crea una nova fila a la taula games_players)
	public GamePlayers addPlayerToGame(Long idGame, Long idPlayer);
	
	// Retorna un llistat amb l'assignació de cada jugador a cada partida
	public List<GamePlayers> listAllGamePlayers();
	
	// Retorna el llistat d'assignacions Partida-Jugador de la partida amb identificador "idGame"
	public List<GamePlayers> listGamePlayersByGame(Long idGame);
	
	// Retorna el llistat d'assignacions Partida-Jugador del jugador amb identificador "playerId"
	public List<GamePlayers> listGamePlayersByPlayer(Long playerId);
	
	// Modifica la instància de la taula games_players de la partida "idGame" i jugador "idPlayer"
	// i guarda aquest jugador com a guanyador de la partida
	public GamePlayers setGameWinner(Long idGame, Long idPlayer);
	
	
}
