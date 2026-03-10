package com.anand.movie_app.service.impl;

import com.anand.movie_app.entity.Seat;
import com.anand.movie_app.repository.SeatRepository;
import com.anand.movie_app.service.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public void addSeat(Seat seat) {
        seatRepository.addSeat(seat);
    }

    @Override
    public Seat getSeatById(int seatId) {
        return seatRepository.getSeatById(seatId);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.getAllSeats();
    }

    @Override
    public void deleteSeat(int seatId) {
        seatRepository.deleteSeat(seatId);
    }
}
