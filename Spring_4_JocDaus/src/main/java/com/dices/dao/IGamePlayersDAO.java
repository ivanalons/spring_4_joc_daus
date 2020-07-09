package com.dices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dices.dto.GamePlayers;

public interface IGamePlayersDAO extends JpaRepository<GamePlayers, Long>{

}
