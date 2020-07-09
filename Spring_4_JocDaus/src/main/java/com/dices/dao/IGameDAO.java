package com.dices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dices.dto.Game;

public interface IGameDAO extends JpaRepository<Game, Long>{

}
