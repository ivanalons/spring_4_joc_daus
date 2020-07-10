package com.dices.service;

import java.util.List;

import com.dices.dto.Toss;

public interface ITossService {

	public Toss createToss(Long gameId, Long playerId);
	
	public List<Toss> listAllTosses();
	
	public List<Toss> listTossesByGame(Long gameId);
	
	public List<Toss> listTossesByPlayer(Long gameId);
	
}
