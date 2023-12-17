package com.movie.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.online.entity.Movie;
import com.movie.online.entity.User;
import com.movie.online.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllMovie")
	public List<Movie> getAllMovies(@RequestBody User user)
	{
		return userService.getAllMovies(user);
	}
	
	@GetMapping("/searchMovies/{name}")
	public List<Movie> searchMovies(@PathVariable("name") String name)
	{
		return userService.searchMovies(name);
	}
	
	@GetMapping("/searchGenre/{name}")
	public List<Movie> serachMoviesByGenre(@PathVariable("name") String name)
	
	{
		return userService.findByGenre(name);
		
	}
	@PostMapping("/addToCart")
	public ResponseEntity<String> addMoviesToCart(@RequestBody List<Movie> movies)
	{
		userService.addToCart(movies);
		return ResponseEntity.ok("Added Movies to Cart Successfully");
	}
	
	@PostMapping("/payment")
	public ResponseEntity<String> paymentmode(@RequestBody String mode)
	{
		return ResponseEntity.ok("selected payment mode"+mode);
	}
	@PostMapping("/paymentCompelted")
	public ResponseEntity<String> paymentCompleted(@RequestBody String compelted)
	{
		return ResponseEntity.ok("payment is completed successfully");
	}

}
