package com.rafael.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.dsmovie.dto.MovieDTO;
import com.rafael.dsmovie.dto.ScoreDTO;
import com.rafael.dsmovie.entities.Movie;
import com.rafael.dsmovie.entities.Score;
import com.rafael.dsmovie.entities.User;
import com.rafael.dsmovie.repositories.MovieRepository;
import com.rafael.dsmovie.repositories.ScoreRepository;
import com.rafael.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {

		User user = userRepository.findByEmail(dto.getEmail());

		/* Salva um novo usuario ("email") caso não existir no banco */
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}

		/* Pega o id do filme que sera avaliado */
		Movie movie = movieRepository.findById(dto.getMovieId()).get();

		/*
		 * salva o score ("pontuação") que foi dado ao filme pegando o usuario salvo e o
		 * filme buscado pelo id
		 */
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());

		score = scoreRepository.saveAndFlush(score);

		/* Calcula o valor da avaliacao ("score") e acrescenta nos que ja tem */
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}

		/* Calcula a media da avaliacao das notas datas a um filme */
		double avg = sum / movie.getScores().size();

		/* Salva a nova media e a contagem de avaliação que o filme teve */
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());

		/* Salva tudo */
		movie = movieRepository.save(movie);

		return new MovieDTO(movie);
	}

}
