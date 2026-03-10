package com.anand.movie_app.service;

import com.anand.movie_app.entity.Seat;
import java.util.List;

public interface SeatService {
    void addSeat(Seat seat);
    Seat getSeatById(int seatId);
    List<Seat> getAllSeats();
    void deleteSeat(int seatId);
}
