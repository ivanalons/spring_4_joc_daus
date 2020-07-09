package com.dices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dices.dto.Player;

public interface IPlayerDAO extends JpaRepository<Player,Long> {

}
