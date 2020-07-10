package com.dices.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="toss")
public class Toss {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="won_toss", nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean wonToss;
	
	@ManyToOne
	@JoinColumns({
	      @JoinColumn(name = "gp_games_id", referencedColumnName = "games_id"),
	      @JoinColumn(name = "gp_players_id", referencedColumnName = "players_id")
	})	
	GamePlayers gamePlayers;
	
	@OneToOne
	@JoinColumn(name="dices_id")
	private Dices dices;
	
	public Toss() {
		
	}
	
	public Toss(Long id, boolean wonToss, GamePlayers gamePlayers, Dices dices) {
		this.id=id;
		this.wonToss = wonToss;
		this.gamePlayers= gamePlayers;
		this.dices = dices;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isWonToss() {
		return wonToss;
	}

	public void setWonToss(boolean wonToss) {
		this.wonToss = wonToss;
	}

	public GamePlayers getGamePlayers() {
		return gamePlayers;
	}

	public void setGamePlayers(GamePlayers gamePlayers) {
		this.gamePlayers = gamePlayers;
	}

	
	public Dices getDices() {
		return dices;
	}

	public void setDices(Dices dice) {
		this.dices = dice;
	}

	
	
	
}
