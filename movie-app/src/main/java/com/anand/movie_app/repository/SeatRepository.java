package com.anand.movie_app.repository;

import com.anand.movie_app.entity.Seat;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class SeatRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addSeat(Seat seat) {
        entityManager.persist(seat);
    }

    public Seat getSeatById(int seatId) {
        return entityManager.find(Seat.class, seatId);
    }

    public List<Seat> getAllSeats() {
        String jpql = "SELECT s FROM Seat s";
        return entityManager.createQuery(jpql, Seat.class).getResultList();
    }

    public void deleteSeat(int seatId) {
        Seat seat = entityManager.find(Seat.class, seatId);
        if (seat != null) {
            entityManager.remove(seat);
        }
    }
}
