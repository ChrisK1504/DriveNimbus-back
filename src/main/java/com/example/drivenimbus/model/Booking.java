package com.example.drivenimbus.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Long BookingID;
    private Date PickupDate;
    private Date ReturnDate;

    @Enumerated(EnumType.STRING)
    private Status BookingStatus;
    private Date CreatedAt;

    // Default constructor
    public Booking() {
    }

    // Parameterized constructor
    public Booking(User user, Car car,Long bookingID, Date pickupDate, Date returnDate,
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

    public Date getPickupDate() {
        return PickupDate;
    }

    public Date getReturnDate() {
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

    public void setPickupDate(Date pickupDate) {
        this.PickupDate = pickupDate;
    }

    public void setReturnDate(Date returnDate) {
        this.ReturnDate = returnDate;
    }

    public void setBookingStatus(Status bookingStatus) {
        this.BookingStatus = bookingStatus;
    }

    public void setCreatedAt(Date createdAt) {
        this.CreatedAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}