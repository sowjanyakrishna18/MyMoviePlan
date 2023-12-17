package com.movie.online.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movie.online.entity.Movie;

import jakarta.transaction.Transactional;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Transactional
	@Modifying
	@Query(value="delete from Movie m where m.name=:name")
	void deleteByName(@Param("name") String name);

	@Query(value="select m from Movie m where m.name like %:name")
	List<Movie> searchMovies(@Param("name")String name);
	
	@Query(value="select g from Genre g where g.name like %:name")
	List<Movie>searchMoviesByGenre(@Param("name") String name);
}
