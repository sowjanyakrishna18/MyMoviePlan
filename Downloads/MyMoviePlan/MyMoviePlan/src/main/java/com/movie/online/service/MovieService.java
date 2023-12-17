package com.movie.online.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.online.entity.Movie;
import com.movie.online.entity.User;
import com.movie.online.repository.MovieRepository;
import com.movie.online.repository.UserRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private UserRepository userRepository;

	public List<Movie> getAllMovies(String username, String password) {
		if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase(password)) {
			return movieRepository.findAll();
		}
		return null;
	}

	public void deleteMovie(User user, Movie movie) {
		User admin = userRepository.findbyname("admin");

		if (user.getUsername().equalsIgnoreCase("admin") && user.getPassword().equalsIgnoreCase(admin.getPassword())) {
			movieRepository.deleteByName(movie.getName());
		}

	}

	public void editMovie(User user, Movie movie) {
		User admin = userRepository.findbyname("admin");

		if (user.getUsername().equalsIgnoreCase("admin") && user.getPassword().equalsIgnoreCase(admin.getPassword())) {
			movieRepository.save(movie);
		}

	}

	public void saveMovie(User user, Movie movie) {
		User admin = userRepository.findbyname("admin");

		if (user.getUsername().equalsIgnoreCase("admin") && user.getPassword().equalsIgnoreCase(admin.getPassword())) {
			movieRepository.save(movie);
		}

	}

	public void saveMovies(User user, List<Movie> movies) {
		User admin = userRepository.findbyname("admin");

		if (user.getUsername().equalsIgnoreCase("admin") && user.getPassword().equalsIgnoreCase(admin.getPassword())) {
			movieRepository.saveAll(movies);
		}
		
	}

}
