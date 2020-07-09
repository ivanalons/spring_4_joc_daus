#DELETE FROM GAMES_PLAYERS;
#DELETE FROM GAMES;
#DELETE FROM PLAYERS;

INSERT INTO PLAYERS(name,register_date) VALUES ('Jugador 1',NOW());
INSERT INTO PLAYERS(name,register_date) VALUES ('Jugador 2',NOW());
INSERT INTO PLAYERS(name,register_date) VALUES ('Jugador 3',NOW());
INSERT INTO PLAYERS(name,register_date) VALUES ('Jugador 4',NOW());
INSERT INTO PLAYERS(name,register_date) VALUES ('Jugador 5',NOW());
INSERT INTO PLAYERS(register_date) VALUES (NOW());

INSERT INTO GAMES_PLAYERS(games_id,players_id) VALUES (1,1);
INSERT INTO GAMES_PLAYERS(games_id,players_id) VALUES (1,2);
INSERT INTO GAMES_PLAYERS(games_id,players_id) VALUES (1,3);
INSERT INTO GAMES_PLAYERS(games_id,players_id) VALUES (2,1);
INSERT INTO GAMES_PLAYERS(games_id,players_id) VALUES (2,2);
INSERT INTO GAMES_PLAYERS(games_id,players_id) VALUES (2,3);
INSERT INTO GAMES_PLAYERS(games_id,players_id) VALUES (2,4);
INSERT INTO GAMES_PLAYERS(games_id,players_id) VALUES (2,5);

INSERT INTO DICES(dice1,dice2) VALUES (1,1);
INSERT INTO DICES(dice1,dice2) VALUES (1,2);
INSERT INTO DICES(dice1,dice2) VALUES (1,3);
INSERT INTO DICES(dice1,dice2) VALUES (1,4);
INSERT INTO DICES(dice1,dice2) VALUES (1,5);
INSERT INTO DICES(dice1,dice2) VALUES (1,6);

INSERT INTO TOSS(won_toss,gp_games_id, gp_players_id, dices_id) VALUES (0,1,1,1);
INSERT INTO TOSS(won_toss,gp_games_id, gp_players_id, dices_id) VALUES (0,1,2,2);
INSERT INTO TOSS(won_toss,gp_games_id, gp_players_id, dices_id) VALUES (0,1,3,3);
INSERT INTO TOSS(won_toss,gp_games_id, gp_players_id, dices_id) VALUES (0,1,1,4);
INSERT INTO TOSS(won_toss,gp_games_id, gp_players_id, dices_id) VALUES (0,1,2,5);
INSERT INTO TOSS(won_toss,gp_games_id, gp_players_id, dices_id) VALUES (1,1,3,6);

UPDATE GAMES_PLAYERS SET won_game=1 WHERE games_id=1 AND players_id=3;









