package com.anand.movie_app.service;

import com.anand.movie_app.entity.Booking;
import com.anand.movie_app.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void addBooking(Booking booking) {
        bookingRepository.addBooking(booking);
    }

    @Override
    public Booking getBookingById(int bookingId) {
        return bookingRepository.getBookingById(bookingId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.getAllBookings();
    }

    @Override
    public void deleteBooking(int bookingId) {
        bookingRepository.deleteBooking(bookingId);
    }
}
