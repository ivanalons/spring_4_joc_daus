package com.dices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dices.dto.Dices;

public interface IDiceDAO extends JpaRepository<Dices,Long>{

}
