package com.dices.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="players")
public class Player {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="register_date")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date registerDate;
	
	@OneToMany
	@JoinColumn(name="players_id")
	private List<GamePlayers> gamePlayers;
	
	public Player() {
		
	}

	public Player(Long id, String name, Date registerDate) {
		this.id = id;
		this.name = name;
		this.registerDate = registerDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	
	
}
