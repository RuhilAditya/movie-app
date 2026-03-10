package com.anand.movie_app.service;

import com.anand.movie_app.entity.Booking;
import java.util.List;

public interface BookingService {
    void addBooking(Booking booking);
    Booking getBookingById(int bookingId);
    List<Booking> getAllBookings();
    void deleteBooking(int bookingId);
}
