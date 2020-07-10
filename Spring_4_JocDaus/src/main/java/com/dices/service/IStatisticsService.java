package com.dices.service;

import java.util.List;
import java.util.Map;

import com.dices.view.PlayerView;

public interface IStatisticsService {

	public List<PlayerView> listPlayersStatistics();
	
	public List<PlayerView> listPlayersRanking();

	public Map<String,Double> getGlobalAverageSuccessRate();
	
	public PlayerView getBestPlayer();
	
	public PlayerView getWorsePlayer();

}
