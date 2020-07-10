package com.dices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dices.dao.IGameDAO;
import com.dices.dao.IGamePlayersDAO;
import com.dices.dao.IPlayerDAO;
import com.dices.dto.Game;
import com.dices.dto.GamePlayers;
import com.dices.dto.Player;
import com.dices.dto.serializable.GamePlayersId;
import com.dices.service.IGamePlayersService;

@Service
public class GamePlayersServiceImpl implements IGamePlayersService{

	@Autowired
	IGamePlayersDAO iGamePlayersDAO;
	@Autowired
	IGameDAO iGameDAO;
	@Autowired
	IPlayerDAO iPlayerDAO;
	
	@Override
	public GamePlayers addPlayerToGame(Long idGame, Long idPlayer) {

		Game game = iGameDAO.findById(idGame).get();
		Player player = iPlayerDAO.findById(idPlayer).get();
		
		GamePlayers gamePlayers = new GamePlayers();
		gamePlayers.setGame(game);
		gamePlayers.setPlayer(player);
		gamePlayers.setWonGame(false);		
		
		gamePlayers.setGamePlayersId(new GamePlayersId(idGame,idPlayer));
		
		return iGamePlayersDAO.save(gamePlayers);

	}

	@Override
	public List<GamePlayers> listGamePlayersByGame(Long gameId) {

		Game game = iGameDAO.findById(gameId).get();

		List<GamePlayers> gamePlayers = game.getGamePlayers();
		
		return gamePlayers;
	}

	@Override
	public GamePlayers setGameWinner(Long idGame, Long idPlayer) {
		
		GamePlayersId gamePlayersId = new GamePlayersId();
		gamePlayersId.setGameId(idGame);
		gamePlayersId.setPlayerId(idPlayer);
		
		GamePlayers gamePlayers = iGamePlayersDAO.findById(gamePlayersId).get();
		
		gamePlayers.setWonGame(true);
		
		return iGamePlayersDAO.save(gamePlayers);
	}


	@Override
	public List<GamePlayers> listAllGamePlayers() {
		
		return iGamePlayersDAO.findAll();
	}

	@Override
	public List<GamePlayers> listGamePlayersByPlayer(Long playerId) {

		Player player = iPlayerDAO.findById(playerId).get();

		List<GamePlayers> gamePlayers = player.getGamePlayers();
		
		return gamePlayers;
	}

}
