package com.movie.online.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.online.entity.Movie;
import com.movie.online.entity.User;
import com.movie.online.repository.MovieRepository;
import com.movie.online.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MovieRepository movieRepository;

	public List<Movie> getAllMovies(User user) {
		return movieRepository.findAll();
	}

	public List<Movie> searchMovies(String name) {

		return movieRepository.searchMovies(name);
	}

	public List<Movie> findByGenre(String name) {

		return movieRepository.searchMoviesByGenre(name);
	}

	public void addToCart(List<Movie> movies) {
		List<Movie> cart=new ArrayList<>();
		cart.addAll(movies);		
	}

}
