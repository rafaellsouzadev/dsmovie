package com.rafael.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.dsmovie.entities.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long>{

}
