package com.anand.movie_app.service;

import com.anand.movie_app.entity.Movie;
import com.anand.movie_app.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getSortedMovies() {
        List<Movie> movies = movieRepository.getAllMovies();
        movies.sort(Comparator.comparingInt(Movie::getMovieId));
        return movies;
    }

    @Override
    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    @Override
    public void removeMovieById(int id) {
        movieRepository.deleteMovie(id);
    }

    @Override
    public void updateMovieById(int id, Movie updatedMovie) {
        movieRepository.updateMovieById(id, updatedMovie);
    }

    @Override
    public Movie getMovieById(int id) {
        return movieRepository.getMovieById(id);
    }


    @Override
    public List<Movie> getMoviesPaginated(int page, int size) {
        List<Movie> movies = movieRepository.getMoviesPaginated(page, size);
        movies.sort(Comparator.comparingInt(Movie::getMovieId));
        return movies;
    }
}
