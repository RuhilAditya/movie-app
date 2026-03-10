package com.anand.movie_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;

    @Column(name = "genre_name", nullable = false, unique = true)
    private String genreName;

    @ManyToMany(mappedBy = "genres")
    @JsonBackReference(value = "movie-genre")
    private Set<Movie> movies;

    // Constructors
    public Genre() {}

    public Genre(String genreName, Set<Movie> movies) {
        this.genreName = genreName;
        this.movies = movies;
    }

    // Getters & Setters
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
