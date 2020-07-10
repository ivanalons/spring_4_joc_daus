package com.dices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dices.dto.Toss;

public interface ITossDAO extends JpaRepository<Toss, Long>{

}
