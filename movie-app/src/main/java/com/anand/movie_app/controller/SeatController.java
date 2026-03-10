package com.anand.movie_app.controller;

import com.anand.movie_app.entity.Seat;
import com.anand.movie_app.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addSeat(@RequestBody Seat seat) {
        seatService.addSeat(seat);
        return ResponseEntity.ok("Seat added successfully!");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable int id) {
        Seat seat = seatService.getSeatById(id);
        if (seat != null) {
            return ResponseEntity.ok(seat);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return ResponseEntity.ok(seats);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSeat(@PathVariable int id) {
        try {
            seatService.deleteSeat(id);
            return ResponseEntity.ok("Seat deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to delete seat: " + e.getMessage());
        }
    }

}