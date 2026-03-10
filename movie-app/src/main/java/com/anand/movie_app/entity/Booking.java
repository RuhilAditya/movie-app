package com.anand.movie_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(name = "booking_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate = new Date();

    @Column(name = "booking_price", nullable = false)
    private int bookingPrice;

    @Column(name = "customer_name", nullable = false, length = 20)
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "movieId", nullable = false)
    @JsonBackReference(value = "movie-booking")
    private Movie movie;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "seat-booking")
    private Seat seat;


    public Booking() {}

    public Booking(Date bookingDate, int bookingPrice, String customerName) {
        this.bookingDate = bookingDate;
        this.bookingPrice = bookingPrice;
        this.customerName = customerName;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(int bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", bookingPrice=" + bookingPrice +
                ", customerName='" + customerName + '\'' +
                ", movie=" + (movie != null ? movie.getMovieName() : "null") +
                '}';
    }
}
