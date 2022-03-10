package com.rafael.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.dsmovie.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
