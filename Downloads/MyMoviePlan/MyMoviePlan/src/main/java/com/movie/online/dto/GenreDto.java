package com.movie.online.dto;

import com.movie.online.entity.Genre;
import com.movie.online.entity.User;

public class GenreDto {
	private User user;
	private Genre genre;
	public GenreDto() {
		super();
	}
	public GenreDto(User user, Genre genre) {
		super();
		this.user = user;
		this.genre = genre;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	

}
