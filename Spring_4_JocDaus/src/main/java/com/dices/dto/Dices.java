package com.dices.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="dices")
public class Dices {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="dice1")
	private int dice1;
	
	@Column(name="dice2")
	private int dice2;

	@OneToOne
	@JoinColumn(name="id")
	private Toss toss;
	

	public Dices() {
		
	}
	
	public Dices(Long id, int dice1, int dice2) {
		this.id = id;
		this.dice1 = dice1;
		this.dice2 = dice2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDice1() {
		return dice1;
	}

	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}

	public int getDice2() {
		return dice2;
	}

	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}
	

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "Toss")
	public Toss getToss() {
		return toss;
	}

	public void setToss(Toss toss) {
		this.toss = toss;
	}
}
