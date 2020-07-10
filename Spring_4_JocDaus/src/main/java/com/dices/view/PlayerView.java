package com.dices.view;

import java.util.Date;

import com.dices.dto.Player;

public class PlayerView {

	private Player player;
	private double successAverageRate;
	
	public PlayerView() {
		
	}

	public PlayerView(Player player, double successAverageRate) {
		this.player = player;
		this.successAverageRate = successAverageRate;
	}

	

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public double getSuccessAverageRate() {
		return successAverageRate;
	}

	public void setSuccessAverageRate(double successAverageRate) {
		this.successAverageRate = successAverageRate;
	}
	
	
	
}
