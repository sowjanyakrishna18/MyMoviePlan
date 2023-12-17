package com.movie.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.movie.online.entity.Movie;
import com.movie.online.entity.User;
import com.movie.online.service.MovieService;

@Controller
public class HomeController {

	@Autowired
	private MovieService movieService;
    @GetMapping("/home")
    public String index() {
        return "index.jsp"; // This will resolve to src/main/resources/templates/index.jsp
    }
    
    @PostMapping("/getAllMoviesHome")
	public String getAllMovies(@RequestBody User user) {
		
		movieService.getAllMovies(user.getUsername(), user.getPassword());
		return "movie.jsp";

	}
}