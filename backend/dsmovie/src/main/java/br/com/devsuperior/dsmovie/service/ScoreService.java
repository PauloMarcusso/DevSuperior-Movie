package br.com.devsuperior.dsmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devsuperior.dsmovie.model.Movie;
import br.com.devsuperior.dsmovie.model.Score;
import br.com.devsuperior.dsmovie.model.User;
import br.com.devsuperior.dsmovie.model.dto.MovieDTO;
import br.com.devsuperior.dsmovie.model.dto.ScoreDTO;
import br.com.devsuperior.dsmovie.repository.MovieRepository;
import br.com.devsuperior.dsmovie.repository.ScoreRepository;
import br.com.devsuperior.dsmovie.repository.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDTO) {

		User user = userRepository.findByEmail(scoreDTO.getEmail());

		if (user == null) {
			user = new User();
			user.setEmail(scoreDTO.getEmail());
			userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDTO.getValue());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum += s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		movie = movieRepository.saveAndFlush(movie);
		
		return new MovieDTO(movie);
	}
}






















