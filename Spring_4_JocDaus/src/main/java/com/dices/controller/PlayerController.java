package com.dices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dices.dto.Player;
import com.dices.service.impl.PlayerServiceImpl;

@RestController
@RequestMapping("/")
public class PlayerController {

	@Autowired
	PlayerServiceImpl playerServiceImpl;
	
	@GetMapping("/players")
	public List<Player> listAllPlayers(){
		
		return playerServiceImpl.listAllPlayers();
	}
	
	@PostMapping("/players")
	public Player createPlayer(@RequestBody Player player) {
		
		return playerServiceImpl.createPlayer(player);
		
	}
	
	@PutMapping("/players/{id}")
	public Player updatePlayer(@PathVariable(name="id") Long playerId, @RequestBody Player player) {
		
		return playerServiceImpl.updatePlayer(playerId,player);
		
	}
	
}
