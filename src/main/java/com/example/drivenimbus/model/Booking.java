package com.example.drivenimbus.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BookingID;

    @ManyToOne
    @JoinColumn(name = "carID", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private Users user;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate PickupDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate ReturnDate;

    @Enumerated(EnumType.STRING)
    private Status BookingStatus;
    private Date CreatedAt;

    // Default constructor
    public Booking() {
    }

    // Parameterized constructor
    public Booking(Users user, Car car,Long bookingID, LocalDate pickupDate, LocalDate returnDate,
                  Status bookingStatus, Date createdAt) {
        this.user = user;
        this.car = car;
        this.BookingID = bookingID;
        this.PickupDate = pickupDate;
        this.ReturnDate = returnDate;
        this.BookingStatus = bookingStatus;
        this.CreatedAt = createdAt;
    }

    // Getters
    public Long getBookingID() {
        return BookingID;
    }

    public LocalDate getPickupDate() {
        return PickupDate;
    }

    public LocalDate getReturnDate() {
        return ReturnDate;
    }

    public Status getBookingStatus() {
        return BookingStatus;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    // Setters
    public void setBookingID(Long bookingID) {
        this.BookingID = bookingID;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.PickupDate = pickupDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.ReturnDate = returnDate;
    }

    public void setBookingStatus(Status bookingStatus) {
        this.BookingStatus = bookingStatus;
    }

    public void setCreatedAt(Date createdAt) {
        this.CreatedAt = createdAt;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}