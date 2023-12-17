package com.movie.online.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.online.entity.Genre;
import com.movie.online.entity.User;
import com.movie.online.repository.GenreRepository;
import com.movie.online.repository.UserRepository;

@Service
public class GenereService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GenreRepository genreRepository;

	public List<Genre> getAllGenres(String username, String password) {
		if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase(password)) {
			return genreRepository.findAll();
		}
		return null;
	}

	public void saveGenre(User user, Genre genre) {
		User admin = userRepository.findbyname("admin");

		if (user.getUsername().equalsIgnoreCase("admin") && user.getPassword().equalsIgnoreCase(admin.getPassword())) {
			genreRepository.save(genre);
		}

	}

	public void editGenre(User user, Genre genre) {
		User admin = userRepository.findbyname("admin");

		if (user.getUsername().equalsIgnoreCase("admin") && user.getPassword().equalsIgnoreCase(admin.getPassword())) {
		genreRepository.save(genre);
		}
	}

	public void deleteGenre(User user,Genre genre) {
		User admin = userRepository.findbyname("admin");

		if (user.getUsername().equalsIgnoreCase("admin") && user.getPassword().equalsIgnoreCase(admin.getPassword())) {
		genreRepository.delete(genre);
		}
	}

}
