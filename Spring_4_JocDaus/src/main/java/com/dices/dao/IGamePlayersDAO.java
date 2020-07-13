package com.dices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dices.dto.GamePlayers;
import com.dices.dto.serializable.GamePlayersId;

// El identificador en lloc de ser Long es de tipus GamePlayersId perque no hi ha un identificador
// unic sino que es una clau primaria composta per partida i jugador
public interface IGamePlayersDAO extends JpaRepository<GamePlayers, GamePlayersId>{

}
