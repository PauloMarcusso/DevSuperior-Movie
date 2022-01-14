package br.com.devsuperior.dsmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devsuperior.dsmovie.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

}
