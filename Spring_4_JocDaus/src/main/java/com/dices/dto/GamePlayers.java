package com.dices.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dices.dto.serializable.GamePlayersId;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="games_players")

public class GamePlayers{
	
	/*//No hay id para la tabla GAME_PLAYERS !!!!!!!
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	*/
	
	@EmbeddedId
    private GamePlayersId gamePlayersId; //Primary Key composta per més d'un camp

	@Column(name="won_game", nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean wonGame;
	
	@MapsId("gameId") //Referencia la Primary Key de l'atribut gamePlayersId.gameId
	@ManyToOne
	@JoinColumn(name="games_id")
	private Game game;
	
	@MapsId("playerId") //Referencia la Primary Key de l'atribut gamePlayersId.playerId
	@ManyToOne
	@JoinColumn(name="players_id")
	private Player player;
	
	
	/*
	@JoinColumns({
	      @JoinColumn(name = "games_id", referencedColumnName = "gp_games_id"),
	      @JoinColumn(name = "players_id", referencedColumnName = "gp_players_id")
	})	*/
	
	// La Foreign Key de la taula toss(Toss) es composta perque fa referencia a la taula 
	// games_players (GamePlayers) que te una Primary Key composta
	@OneToMany
	@JoinColumns({
	      @JoinColumn(name = "gp_games_id"),
	      @JoinColumn(name = "gp_players_id")
	})	
	private List<Toss> tossList;
	
	public GamePlayers() {
		
	}

	public GamePlayers(GamePlayersId gamePlayersId, boolean wonGame, Game game, Player player) { //TODO
		this.gamePlayersId = new GamePlayersId();
		this.gamePlayersId.setGameId(gamePlayersId.getGameId());
		this.gamePlayersId.setPlayerId(gamePlayersId.getPlayerId());
		this.wonGame = wonGame;
		this.game = game;
		this.player = player;
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

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Toss")
	public List<Toss> getTossList() {
		return tossList;
	}

	public void setTossList(List<Toss> toss) {
		this.tossList = toss;
	}
	
	
}
