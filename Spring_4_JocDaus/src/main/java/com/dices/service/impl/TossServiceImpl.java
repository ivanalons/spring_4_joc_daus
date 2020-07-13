package com.dices.service.impl;

import java.util.ArrayList;
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
	
	@Autowired
	GamePlayersServiceImpl gamePlayersServiceImpl;
	
	//Realitza una nova tirada de daus del jugador amb id "playerId" a la partida amb id "gameId" 
	@Override
	public Toss createToss(Long gameId, Long playerId) {

		// s'obte la instancia de la taula games_players a partir de la clau primaria composta
		// games_id i players_id
		GamePlayersId id = new GamePlayersId(gameId,playerId);
		
		GamePlayers gamePlayers = iGamePlayersDAO.findById(id).get();
		
		// es crea una nova instancia de la taula toss amb foreign key referenciant una instancia
		// de la taula games_players
		Toss toss = new Toss();
		toss.setWonToss(false);
		toss.setGamePlayers(gamePlayers);
		
		// s'afegeix la foreign key a la instancia de la taula dices
		Dices dices = this.tossDices();
		toss.setDices(dices);
		
		int sum = dices.getDice1() + dices.getDice2();
		//System.out.println(dices.toString()+ " SUMA = "+sum);
		if (sum == 7) {
			toss.setWonToss(true); // la tirada s'ha guanyat si la suma dels daus es 7
		}
		
		return iTossDAO.save(toss);
		
	}

	// Crea una nou resultat de daus i el guarda a la taula DICES i el retorna en objecte Dices
	private Dices tossDices() {
		
		Dices dices = new Dices();
		
		int valueDice1 = (int)(Math.random()*6)+1;
		int valueDice2 = (int)(Math.random()*6)+1;
		
		dices.setDice1(valueDice1);
		dices.setDice2(valueDice2);
		
		Dices newDice = iDiceDAO.save(dices);
		
		return newDice;
	}
	
	public void deleteAllPlayerTossesByGame(Long gameId, Long playerId) {
		
		GamePlayersId id = new GamePlayersId(gameId,playerId);
		
		GamePlayers gamePlayers = iGamePlayersDAO.findById(id).get();
		
		for(Toss toss : gamePlayers.getTossList()) {
			iTossDAO.deleteById(toss.getId());
		}
		
	}
	
	@Override
	public List<Toss> listAllTosses() {

		return iTossDAO.findAll();
	}

	@Override
	public List<Toss> listTossesByGame(Long gameId) {
		List<GamePlayers> gamePlayersList = gamePlayersServiceImpl.listGamePlayersByGame(gameId);
		
		List<Toss> listTossesByGame = new ArrayList<>();
		
		for (GamePlayers gp : gamePlayersList) {
			listTossesByGame.addAll(gp.getTossList());
		}
		
		return listTossesByGame;
	}

	@Override
	public List<Toss> listTossesByPlayer(Long playerId) {

		List<GamePlayers> gamePlayersList = gamePlayersServiceImpl.listGamePlayersByPlayer(playerId);
		
		List<Toss> listTossesByPlayer = new ArrayList<>();
		
		for (GamePlayers gp : gamePlayersList) {
			listTossesByPlayer.addAll(gp.getTossList());
		}
		
		return listTossesByPlayer;
	}

}
