package com.dices.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="games_players")
public class GamePlayers {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="won_game", nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean wonGame;
	
	@ManyToOne
	@JoinColumn(name="games_id")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name="players_id")
	private Player player;
	
	public GamePlayers() {
		
	}

	public GamePlayers(Long id, boolean wonGame) {
		this.id = id;
		this.wonGame = wonGame;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isWonGame() {
		return wonGame;
	}

	public void setWonGame(boolean wonGame) {
		this.wonGame = wonGame;
	}

	
	
}
