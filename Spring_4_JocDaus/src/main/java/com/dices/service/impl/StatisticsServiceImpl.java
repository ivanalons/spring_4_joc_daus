package com.dices.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dices.dao.IPlayerDAO;
import com.dices.dto.Player;
import com.dices.dto.Toss;
import com.dices.service.IStatisticsService;
import com.dices.view.PlayerView;

@Service
public class StatisticsServiceImpl implements IStatisticsService{

	@Autowired
	TossServiceImpl tossServiceImpl;

	@Autowired	
	IPlayerDAO iPlayerDAO;
	
	@Override
	public List<PlayerView> listPlayersStatistics() {

		List<PlayerView> statisticsList = new ArrayList<>();
		
		List<Player> playersList = iPlayerDAO.findAll();
		
		for( Player p : playersList) {
			
			PlayerView newPlayer = getPlayerStatistics(p);
			statisticsList.add(newPlayer);
			
		}
		
		return statisticsList;
	}
	
	private PlayerView getPlayerStatistics(Player p) {
		Long playerId = p.getId();
		
		List<Toss> tossesList = tossServiceImpl.listTossesByPlayer(playerId);
		
		double tossesNumber = tossesList.size();
		double winnerNumber = 0;
		
		for( Toss t : tossesList ) {
			if(t.isWonToss()) winnerNumber++;
		}
		
		double winrate = 0;
		if (tossesNumber !=0 ) {
			winrate = (winnerNumber / tossesNumber) * 100;
		}
		
		PlayerView newPlayer = new PlayerView(p,winrate);
		
		return newPlayer;
	}

	@Override
	public List<PlayerView> listPlayersRanking() {
		
		List<PlayerView> statisticsList = this.listPlayersStatistics();
		Collections.sort(statisticsList,((a,b) -> 
				(int)(b.getSuccessAverageRate()*100) - (int)(a.getSuccessAverageRate()*100)));
		
		return statisticsList;
	}

	@Override
	public Map<String, Double> getGlobalAverageSuccessRate() {
		List<PlayerView> listPlayers = this.listPlayersStatistics();
		
		int count = 0;
		double sum = 0;
		
		for ( PlayerView player : listPlayers ) {
//			System.out.println("player "+count+": rate="+player.getSuccessAverageRate());
			sum += player.getSuccessAverageRate();
			count++;
		}
		
		double avgRate = 0;
		if (count!=0) avgRate = (sum/count);
		
//		System.out.println("totalSum : count="+count+": sum="+sum);
//		System.out.println("AVG :" + " avg="+avgRate);


		
		Map<String,Double> map = new HashMap<>();
		map.put("systemSuccessRate", avgRate);
		
		return map;
	}

	@Override
	public PlayerView getBestPlayer() {

		List<PlayerView> players = this.listPlayersRanking();
		return players.get(0);
	}

	@Override
	public PlayerView getWorsePlayer() {
		
		List<PlayerView> players = this.listPlayersRanking();
		return players.get(players.size()-1);
		
	}

}
