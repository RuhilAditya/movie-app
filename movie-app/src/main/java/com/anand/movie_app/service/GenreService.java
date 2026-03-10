package com.anand.movie_app.service;

import com.anand.movie_app.entity.Genre;
import com.anand.movie_app.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre addGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre getGenre(int id) {
        return genreRepository.findById(id);
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public void deleteGenre(int id) {
        genreRepository.delete(id);
    }
}
