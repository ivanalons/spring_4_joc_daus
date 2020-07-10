package com.dices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dices.dto.GamePlayers;
import com.dices.service.impl.GamePlayersServiceImpl;

@RestController
@RequestMapping("/games_players/")
public class GamePlayersController {

	@Autowired
	GamePlayersServiceImpl gamePlayersServiceImpl; 
	
	@GetMapping("/")
	public List<GamePlayers> listAllGamePlayers(){
		
		return gamePlayersServiceImpl.listAllGamePlayers();
		
	}
	
	@GetMapping("/games/{id}/players")
	public List<GamePlayers> listGamePlayersByGame(@PathVariable(name="id") Long gameId){
		
		return gamePlayersServiceImpl.listGamePlayersByGame(gameId);
		
	}
	
	@PostMapping("/games/{id1}/players/{id2}")
	public GamePlayers addPlayerToGame(@PathVariable(name="id1") Long gameId,
									   @PathVariable(name="id2") Long playerId){
		
		return gamePlayersServiceImpl.addPlayerToGame(gameId,playerId);
		
	}
	
	@GetMapping("/players/{id}/games")
	public List<GamePlayers> listGamePlayersByPlayer(@PathVariable(name="id") Long playerId){
		
		return gamePlayersServiceImpl.listGamePlayersByPlayer(playerId);
		
	}
	
	@PutMapping("/games/{id1}/players/{id2}/winner")
	public GamePlayers setGameWinner(@PathVariable(name="id1") Long gameId,
										   @PathVariable(name="id2") Long playerId){
		
		return gamePlayersServiceImpl.setGameWinner(gameId, playerId);
		
	}
	
}
