package com.example.drivenimbus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

enum Status {
    PENDING,
    CONFIRMED,
    CANCELLED
}

@Entity
public class Booking {
    @Id
    private Long BookingID;
    private Date PickupDate;
    private Date ReturnDate;
    private Status BookingStatus;
    private Date CreatedAt;

    // Default constructor
    public Booking() {
    }

    // Parameterized constructor
    public Booking(Long bookingID, Date pickupDate, Date returnDate, 
                  Status bookingStatus, Date createdAt) {
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
}