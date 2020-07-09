package com.dices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dices.dao.IGameDAO;
import com.dices.dto.Game;
import com.dices.service.IGameService;

@Service
public class GameServiceImpl implements IGameService{

	@Autowired
	IGameDAO iGameDAO;
	
	@Override
	public Game createGame(Game game) {

		return iGameDAO.save(game);
	}

	@Override
	public List<Game> listAllGames() {

		return iGameDAO.findAll();
	}

}