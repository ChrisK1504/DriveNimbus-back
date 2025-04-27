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
    // private Long CarID; // Foreign Key
    // private Long UserID; // Foreign Key
    private Date PickupDate;
    private Date ReturnDate;
    private Status BookingStatus;
    private Date CreatedAt;
}
