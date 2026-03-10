package com.anand.movie_app.repository;

import com.anand.movie_app.entity.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class MovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Movie> getAllMovies() {
        String jpql = "SELECT m FROM Movie m";
        return entityManager.createQuery(jpql, Movie.class).getResultList();
    }

    public void addMovie(Movie movie) {
        if (movie.getMovieId() == 0) {
            entityManager.persist(movie);
        } else {
            entityManager.merge(movie);
        }

    }

    public Movie getMovieById(int id) {
        return entityManager.find(Movie.class, id);
    }

    public void updateMovieById(int movieId, Movie updatedMovie) {
        Movie existing = entityManager.find(Movie.class, movieId);
        if (existing != null) {
            existing.setMovieName(updatedMovie.getMovieName());
            existing.setMovieDesc(updatedMovie.getMovieDesc());
            existing.setMovieRating(updatedMovie.getMovieRating());
            entityManager.merge(existing);
        }
    }

    public void deleteMovie(int movieId) {
        Movie movie = entityManager.find(Movie.class, movieId);
        if (movie != null) {
            entityManager.remove(movie);
        }
    }

    public List<Movie> getMoviesPaginated(int page, int size) {
        String jpql = "SELECT m FROM Movie m";
        return entityManager.createQuery(jpql, Movie.class)
                .setFirstResult(page * size)
                .setMaxResults(size)
                .getResultList();
    }
}
