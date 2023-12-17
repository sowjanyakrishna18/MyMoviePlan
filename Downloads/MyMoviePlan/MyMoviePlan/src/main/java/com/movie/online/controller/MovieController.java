package com.movie.online.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.movie.online.dto.MovieDto;
import com.movie.online.dto.MovieListDto;
import com.movie.online.entity.Movie;
import com.movie.online.entity.User;
import com.movie.online.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/")
	public String getMovieHomePage() {
		
		return "index";
	}

	@PostMapping("/getAllMovies")
	public List<Movie> getAllMovies(@RequestBody User user) {
		
		return movieService.getAllMovies(user.getUsername(), user.getPassword());

	}
	@PostMapping("/saveAllMovies")
	public ResponseEntity<String> saveAllMovies(@RequestBody MovieListDto movieListDto) {
		movieService.saveMovies(movieListDto.getUser(),movieListDto.getMovies());
		return ResponseEntity.ok("movies saved successfully");

	}
	@PostMapping("/saveMovie")
	public ResponseEntity<String> saveMovie(@RequestBody MovieDto movieDto) {
		
		movieService.saveMovie(movieDto.getUser(),movieDto.getMovie());
		return ResponseEntity.ok("movie saved successfully");

	}
	@PutMapping("/editMovie")
	public ResponseEntity<String> editMovie(@RequestBody MovieDto movieDto) {
		
		movieService.editMovie(movieDto.getUser(),movieDto.getMovie());
		return ResponseEntity.ok("movie edited successfully");

	}
	@DeleteMapping("/deleteMovie")
	public ResponseEntity<String> deleteMovie(@RequestBody MovieDto movieDto) {
		
		movieService.deleteMovie(movieDto.getUser(),movieDto.getMovie());
		return ResponseEntity.ok("movie deleted successfully");

	}

}
