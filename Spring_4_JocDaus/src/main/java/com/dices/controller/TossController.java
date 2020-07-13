package com.dices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dices.dto.Toss;
import com.dices.service.impl.TossServiceImpl;
import com.dices.view.TossView;

@RestController
@RequestMapping("/toss")
public class TossController {

	@Autowired
	TossServiceImpl tossServiceImpl;
	
	@PostMapping("/games/{id1}/players/{id2}")
	public TossView createToss(@PathVariable(name="id1") Long gameId, 
							@PathVariable(name="id2")Long playerId) {
		
		Toss toss = tossServiceImpl.createToss(gameId, playerId);
		
		return simplifyJSONResponse(toss);
	}

	@GetMapping("/")
	public List<TossView> listAllToss() {
		
		List<Toss> listTosses = tossServiceImpl.listAllTosses();
		
		return simplifyJSONResponse(listTosses);
		
	}
	
	@DeleteMapping("/games/{id1}/players/{id2}")
	public void deleteAllPlayerTossesByGame(@PathVariable(name="id1") Long gameId, 
											@PathVariable(name="id2")Long playerId) {
		tossServiceImpl.deleteAllPlayerTossesByGame(gameId, playerId);
		
	}
	
	
	@GetMapping("/games/{id}/tosses")
	public List<TossView> listTossesByGame(@PathVariable(name="id") Long gameId) {
		
		List<Toss> listTosses = tossServiceImpl.listTossesByGame(gameId);
		
		return simplifyJSONResponse(listTosses);
	}
	
	@GetMapping("/players/{id}/tosses")
	public List<TossView> listTossesByPlayer(@PathVariable(name="id") Long playerId) {
		
		List<Toss> listTosses = tossServiceImpl.listTossesByPlayer(playerId);
		
		return simplifyJSONResponse(listTosses);
		
	}
	
	// Mapear la lista de objetos DTOs Toss con la definición de la BBDD en una lista de 
	// objetos TossView con una definicion JSON mas sencilla para enviar al FrontEnd mediante
	// REST
	private List<TossView> simplifyJSONResponse(List<Toss> listTosses){
		List<TossView> listTossesView = new ArrayList<>();
		
		for (Toss toss : listTosses) {
			TossView view = new TossView(toss);
			listTossesView.add(view);
		}
		
		return listTossesView;
	}
	
	private TossView simplifyJSONResponse(Toss toss) {
		return new TossView(toss);
	}
}
