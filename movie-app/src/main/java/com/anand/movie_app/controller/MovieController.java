package com.anand.movie_app.controller;

import com.anand.movie_app.entity.Movie;
import com.anand.movie_app.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello! Welcome to the Movie App.";
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getSortedMovies();
    }

    @GetMapping("get/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.ok("Movie added successfully!");
    }

    @GetMapping("/paginated")
    public ResponseEntity<List<Movie>> getMoviesPaginated(@RequestParam int page, @RequestParam int size) {
        List<Movie> movies = movieService.getMoviesPaginated(page, size);
        return ResponseEntity.ok(movies);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeMovie(@PathVariable int id) {
        movieService.removeMovieById(id);
        return ResponseEntity.ok("Movie deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable int id, @RequestBody Movie updatedMovie) {
        movieService.updateMovieById(id, updatedMovie);
        return ResponseEntity.ok("Movie updated successfully!");
    }
}
