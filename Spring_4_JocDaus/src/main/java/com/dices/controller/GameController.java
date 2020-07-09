package com.dices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dices.dto.Game;
import com.dices.dto.Player;
import com.dices.service.impl.GameServiceImpl;

@RestController
@RequestMapping("/")
public class GameController {

	@Autowired
	GameServiceImpl gameServiceImpl;
	
	@GetMapping("/games")
	public List<Game> listAllGames(){
		
		return gameServiceImpl.listAllGames();
	}
	
	@PostMapping("/games")
	public Game createGame(@RequestBody Game game) {
		
		return gameServiceImpl.createGame(game);
		
	}
	
}
