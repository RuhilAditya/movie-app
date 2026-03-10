package com.anand.movie_app.repository;

import com.anand.movie_app.entity.Booking;
import com.anand.movie_app.entity.Seat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BookingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addBooking(Booking booking) {
        Seat seat = booking.getSeat();

        if (seat != null && seat.getSeatId() != 0) {
            Seat existingSeat = entityManager.find(Seat.class, seat.getSeatId());
            if (existingSeat != null) {
                existingSeat.setBooking(booking);
                booking.setSeat(existingSeat);
            }
        } else if (seat != null) {
            seat.setBooking(booking);
        }

        entityManager.persist(booking);
    }

    public Booking getBookingById(int bookingId) {
        Booking booking = entityManager.find(Booking.class, bookingId);

        if (booking != null) {
            if (booking.getSeat() != null) {
                booking.getSeat().getSeatNumber();
            }
            if (booking.getMovie() != null) {
                booking.getMovie().getMovieName();
            }
        }

        return booking;
    }


    public List<Booking> getAllBookings() {
        String jpql = "SELECT b FROM Booking b";
        return entityManager.createQuery(jpql, Booking.class).getResultList();
    }

    public void deleteBooking(int bookingId) {
        Booking booking = entityManager.find(Booking.class, bookingId);
        if (booking != null) {
            entityManager.remove(booking);
        }
    }
}
