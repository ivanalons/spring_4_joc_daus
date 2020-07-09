package com.dices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dices.dto.GamePlayers;
import com.dices.dto.serializable.GamePlayersId;

public interface IGamePlayersDAO extends JpaRepository<GamePlayers, GamePlayersId>{

}
