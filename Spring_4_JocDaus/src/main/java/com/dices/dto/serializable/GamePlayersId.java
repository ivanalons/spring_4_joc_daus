package com.dices.dto.serializable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GamePlayersId implements Serializable{

	private Long gameId;
	
    private Long playerId;
  
    public GamePlayersId() {
    	
    }
    
    public GamePlayersId(Long gameId, Long playerId) {
        this.gameId = gameId;
        this.playerId = playerId;
    }

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
 
	
}
