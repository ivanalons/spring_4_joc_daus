package com.dices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dices.dao.IPlayerDAO;
import com.dices.dto.Player;
import com.dices.service.IPlayerService;

@Service
public class PlayerServiceImpl implements IPlayerService{

	@Autowired
	IPlayerDAO iPlayerDAO;
	
	@Override
	public Player createPlayer(Player player) {

		return iPlayerDAO.save(player);
	}

	@Override
	public Player updatePlayer(Long playerId, Player player) {

		Player updatedPlayer = iPlayerDAO.findById(playerId).get();
		
		updatedPlayer.setName(player.getName());
		
		return iPlayerDAO.save(updatedPlayer);
	}

	@Override
	public List<Player> listAllPlayers() {

		return iPlayerDAO.findAll();
	}

	
	
}
