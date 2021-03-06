package com.dices.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="games")
public class Game {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="date")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date date;
	
	@OneToMany
	@JoinColumn(name="games_id")
	private List<GamePlayers> gamePlayers;
	
	
	public Game() {
		
	}

	public Game(Long id, Date date) {
		this.id = id;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "GamePlayers")
	public List<GamePlayers> getGamePlayers() {
		return gamePlayers;
	}

	public void setGamePlayers(List<GamePlayers> gamePlayers) {
		this.gamePlayers = gamePlayers;
	}
	
	
	
}
