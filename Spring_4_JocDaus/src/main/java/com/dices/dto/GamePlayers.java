package com.dices.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.dices.dto.serializable.GamePlayersId;

@Entity
@Table(name="games_players")

public class GamePlayers{
	
	/*//No hay id para la tabla GAME_PLAYERS !!!!!!!
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	*/
	
	@EmbeddedId
    private GamePlayersId gamePlayersId;

	@Column(name="won_game", nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean wonGame;
	
	@MapsId("gameId")
	@ManyToOne
	@JoinColumn(name="games_id")
	private Game game;
	
	@MapsId("playerId")
	@ManyToOne
	@JoinColumn(name="players_id")
	private Player player;
	
	public GamePlayers() {
		
	}

	public GamePlayers(GamePlayersId gamePlayersId, boolean wonGame) { //TODO
		this.gamePlayersId = new GamePlayersId();
		this.gamePlayersId.setGameId(gamePlayersId.getGameId());
		this.gamePlayersId.setPlayerId(gamePlayersId.getPlayerId());
		this.wonGame = wonGame;
	}

	public boolean isWonGame() {
		return wonGame;
	}

	public void setWonGame(boolean wonGame) {
		this.wonGame = wonGame;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public GamePlayersId getGamePlayersId() {
		return gamePlayersId;
	}

	public void setGamePlayersId(GamePlayersId gamePlayersId) {
		this.gamePlayersId = gamePlayersId;
	}
	
	
}
