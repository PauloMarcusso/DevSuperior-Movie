package br.com.devsuperior.dsmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devsuperior.dsmovie.model.Movie;
import br.com.devsuperior.dsmovie.model.dto.MovieDTO;
import br.com.devsuperior.dsmovie.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Transactional
	public Page<MovieDTO> findAll(Pageable pageable){
		Page<Movie> result = repository.findAll(pageable);
		Page<MovieDTO> page = result.map(movie -> new MovieDTO(movie));
		return page;
	}
	
	public MovieDTO findById(Long id) {
		Movie movie = repository.findById(id).get();
		MovieDTO result = new MovieDTO(movie);
		return result;
	}
}
