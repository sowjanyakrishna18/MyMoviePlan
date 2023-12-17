package com.movie.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.online.dto.GenreDto;
import com.movie.online.entity.Genre;
import com.movie.online.entity.User;
import com.movie.online.service.GenereService;

@RestController
public class GenreController {
	@Autowired
	private GenereService genreService;
	
	@PostMapping("/getAllGenres")
	public List<Genre> getAllGenres(@RequestBody User user)
	{
		return genreService.getAllGenres(user.getUsername(),user.getPassword());
	}
	@PostMapping("/saveAllGenres")
	public ResponseEntity<String> saveAllGenres(@RequestBody GenreDto genreDto) {
		genreService.saveGenre(genreDto.getUser(),genreDto.getGenre());
		return ResponseEntity.ok("genres saved successfully");

	}
	@PostMapping("/saveGenres")
	public ResponseEntity<String> saveGenre(@RequestBody GenreDto genreDto) {
		
		genreService.saveGenre(genreDto.getUser(),genreDto.getGenre());
		return ResponseEntity.ok("genre saved successfully");

	}
	@PutMapping("/editGenres")
	public ResponseEntity<String> editGenre(@RequestBody GenreDto genreDto) {
		
		genreService.editGenre(genreDto.getUser(),genreDto.getGenre());
		return ResponseEntity.ok("Genre edited successfully");

	}
	@DeleteMapping("/deleteGenres")
	public ResponseEntity<String> deleteGenre(@RequestBody GenreDto genreDto) {
		
		genreService.deleteGenre(genreDto.getUser(),genreDto.getGenre());
		return ResponseEntity.ok("Genre deleted successfully");

	}
	

}
