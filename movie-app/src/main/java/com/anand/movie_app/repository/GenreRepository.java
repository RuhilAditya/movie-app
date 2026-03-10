package com.anand.movie_app.repository;

import com.anand.movie_app.entity.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class GenreRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Genre save(Genre genre) {
        entityManager.persist(genre);
        return genre;
    }

    public Genre findById(int id) {
        return entityManager.find(Genre.class, id);
    }

    public List<Genre> findAll() {
        return entityManager.createQuery("SELECT g FROM Genre g", Genre.class).getResultList();
    }

    public void delete(int id) {
        Genre genre = findById(id);
        if (genre != null) {
            entityManager.remove(genre);
        }
    }
}
