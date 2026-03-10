package com.anand.movie_app.service;

import com.anand.movie_app.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<Movie> getSortedMovies();
    void addMovie(Movie movie);
    void removeMovieById(int id);
    void updateMovieById(int id, Movie updatedMovie);
    Movie getMovieById(int id);
    List<Movie> getMoviesPaginated(int page, int size);
}
