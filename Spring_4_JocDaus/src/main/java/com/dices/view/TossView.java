package com.dices.view;

import com.dices.dto.Dices;
import com.dices.dto.Toss;

public class TossView {

	private Long idToss;
	
	private Long idGame;
	
	private Long idPlayer;
	
	private boolean wonToss;
	
	private Dices dices;

	
	public TossView() {
		
	}
	
	public TossView(Toss toss) {
		this.idToss = toss.getId();
		this.idGame = toss.getGamePlayers().getGame().getId();
		this.idPlayer = toss.getGamePlayers().getPlayer().getId();
		this.wonToss = toss.isWonToss();
		this.dices = toss.getDices();
	}

	public boolean isWonToss() {
		return wonToss;
	}

	public void setWonToss(boolean wonToss) {
		this.wonToss = wonToss;
	}

	public Long getIdToss() {
		return idToss;
	}

	public void setIdToss(Long idToss) {
		this.idToss = idToss;
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

	public Dices getDices() {
		return dices;
	}

	public void setDices(Dices dices) {
		this.dices = dices;
	}
	
	
}
