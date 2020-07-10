package com.dices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dices.dto.Toss;
import com.dices.service.impl.TossServiceImpl;

@RestController
@RequestMapping("/toss")
public class TossController {

	@Autowired
	TossServiceImpl tossServiceImpl;
	
	@PostMapping("/games/{id1}/players/{id2}")
	public Toss createToss(@PathVariable(name="id1") Long gameId, 
							@PathVariable(name="id2")Long playerId) {
		
		return tossServiceImpl.createToss(gameId, playerId);
		
	}

	@GetMapping("/")
	public List<Toss> listAllToss() {
		
		return tossServiceImpl.listAllToss();
		
	}
	
}
