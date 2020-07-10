package com.dices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dices.dao.IDiceDAO;
import com.dices.dao.IGamePlayersDAO;
import com.dices.dao.ITossDAO;
import com.dices.dto.Dices;
import com.dices.dto.GamePlayers;
import com.dices.dto.Toss;
import com.dices.dto.serializable.GamePlayersId;
import com.dices.service.ITossService;

@Service
public class TossServiceImpl implements ITossService{
	
	@Autowired
	ITossDAO iTossDAO;
	
	@Autowired
	IGamePlayersDAO iGamePlayersDAO;
	
	@Autowired
	IDiceDAO iDiceDAO;
	
	@Override
	public Toss createToss(Long gameId, Long playerId) {

		GamePlayersId id = new GamePlayersId(gameId,playerId);
		
		GamePlayers gamePlayers = iGamePlayersDAO.findById(id).get();
		
		Toss toss = new Toss();
		toss.setWonToss(false);
		toss.setGamePlayers(gamePlayers);
		
		Dices dices = this.tossDices();
		toss.setDices(dices);
		
		int sum = dices.getDice1() + dices.getDice2();
		//System.out.println(dices.toString()+ " SUMA = "+sum);
		if (sum == 7) {
			toss.setWonToss(true);
		}
		
		return iTossDAO.save(toss);
		
	}

	private Dices tossDices() {
		
		Dices dices = new Dices();
		
		int valueDice1 = (int)(Math.random()*6)+1;
		int valueDice2 = (int)(Math.random()*6)+1;
		
		dices.setDice1(valueDice1);
		dices.setDice2(valueDice2);
		
		Dices newDice = iDiceDAO.save(dices);
		
		return newDice;
	}
	
	@Override
	public List<Toss> listAllToss() {

		return iTossDAO.findAll();
	}

	@Override
	public List<Toss> listTossByGame(Long gameId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Toss> listTossByPlayer(Long gameId) {
		// TODO Auto-generated method stub
		return null;
	}

}
