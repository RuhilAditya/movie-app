package com.anand.movie_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "rownumber", nullable = false)
    private String rowNumber;

    @OneToOne
    @JoinColumn(name = "bookingId", unique = true)
    @JsonBackReference
    private Booking booking;

    public Seat() {}

    public Seat(String seatNumber, String rowNumber, Booking booking) {
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.booking = booking;
    }

    public int getSeatId() { return seatId; }
    public void setSeatId(int seatId) { this.seatId = seatId; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public String getRowNumber() { return rowNumber; }
    public void setRowNumber(String rowNumber) { this.rowNumber = rowNumber; }

    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }
}
