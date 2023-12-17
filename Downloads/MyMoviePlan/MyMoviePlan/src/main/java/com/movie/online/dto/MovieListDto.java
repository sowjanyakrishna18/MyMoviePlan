package com.movie.online.dto;

import java.util.List;

import com.movie.online.entity.Movie;
import com.movie.online.entity.User;

public class MovieListDto {
	private User user;
	private List<Movie> movies;
	public MovieListDto() {
		super();
	}
	public MovieListDto(User user, List<Movie> movies) {
		super();
		this.user = user;
		this.movies = movies;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
}
