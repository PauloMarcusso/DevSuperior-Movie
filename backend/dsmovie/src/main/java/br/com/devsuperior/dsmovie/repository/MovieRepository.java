package br.com.devsuperior.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devsuperior.dsmovie.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
