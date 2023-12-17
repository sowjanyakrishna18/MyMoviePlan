package com.movie.online.dto;

import com.movie.online.entity.Movie;
import com.movie.online.entity.User;

public class MovieDto {

	private User user;
	private Movie movie;
	public MovieDto() {
		super();
	}
	public MovieDto(User user, Movie movie) {
		super();
		this.user = user;
		this.movie = movie;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
}
