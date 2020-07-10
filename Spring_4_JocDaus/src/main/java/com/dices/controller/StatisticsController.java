package com.dices.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dices.service.impl.StatisticsServiceImpl;
import com.dices.view.PlayerView;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

	@Autowired
	StatisticsServiceImpl statisticsServiceImpl;
	
	@GetMapping("/players")
	public List<PlayerView> listPlayersStatistics(){
		return statisticsServiceImpl.listPlayersStatistics();
	}
	
	@GetMapping("/players/ranking")
	public List<PlayerView> listPlayersRanking(){
		return statisticsServiceImpl.listPlayersRanking();
	}
	
	@GetMapping("/players/winner")
	public PlayerView getBestPlayer(){
		return statisticsServiceImpl.getBestPlayer();
	}
	
	@GetMapping("/players/loser")
	public PlayerView getWorsePlayer(){
		return statisticsServiceImpl.getWorsePlayer();
	}
	
	@GetMapping("/systemRate")
	public Map<String,Double> getGlobalAverageSuccessRate(){
		return statisticsServiceImpl.getGlobalAverageSuccessRate();
	}
	
}
