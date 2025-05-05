package com.example.drivenimbus.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class DiscountCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codeID;

    @ManyToOne
//    @JoinColumn(name = "bookingID", nullable = false)
    private Booking booking;

    private String discountCode;
    private Double discountAmount;
    private LocalDate expiryDate;
    private Boolean isActive;

    // Default constructor
    public DiscountCode() {
    }

    // Constructor with all fields
    public DiscountCode(Long codeID, String discountCode, Double discountAmount, LocalDate expiryDate, Boolean isActive) {
        this.codeID = codeID;
        this.discountCode = discountCode;
        this.discountAmount = discountAmount;
        this.expiryDate = expiryDate;
        this.isActive = isActive;
    }

    public Long getCodeID() {
        return codeID;
    }

    public void setCodeID(Long codeID) {
        this.codeID = codeID;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}