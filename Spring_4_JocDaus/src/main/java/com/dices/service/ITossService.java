package com.dices.service;

import java.util.List;

import com.dices.dto.Toss;

public interface ITossService {

	public Toss createToss(Long gameId, Long playerId);
	
	public List<Toss> listAllToss();
	
	public List<Toss> listTossByGame(Long gameId);
	
	public List<Toss> listTossByPlayer(Long gameId);
	
}
