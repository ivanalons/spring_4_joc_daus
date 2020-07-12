package com.dices.view;

import com.dices.dto.GamePlayers;

public class GamePlayersView {

	private Long idGame;
	private Long idPlayer;
	private boolean wonGame;
	
	public GamePlayersView() {
		
	}
	
	public GamePlayersView(GamePlayers gamePlayers) {
		this.idGame = gamePlayers.getGame().getId();
		this.idPlayer = gamePlayers.getPlayer().getId();
		this.wonGame = gamePlayers.isWonGame();
	}

	public Long getIdGame() {
		return idGame;
	}

	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}

	public Long getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}

	public boolean isWonGame() {
		return wonGame;
	}

	public void setWonGame(boolean wonGame) {
		this.wonGame = wonGame;
	}
	
	
}
