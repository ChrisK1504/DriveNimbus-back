package com.example.drivenimbus.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class DiscountCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CodeID;

    @ManyToOne
    @JoinColumn(name = "bookingID", nullable = false)
    private Booking booking;

    private String DiscountCode;
    private Double DiscountAmount;
    private LocalDate ExpiryDate;
    private Boolean IsActive;

    // Default constructor
    public DiscountCode() {
    }

    // Constructor with all fields
    public DiscountCode(Long codeID, String discountCode, Double discountAmount, LocalDate expiryDate, Boolean isActive) {
        CodeID = codeID;
        DiscountCode = discountCode;
        DiscountAmount = discountAmount;
        ExpiryDate = expiryDate;
        IsActive = isActive;
    }

    public Long getCodeID() {
        return CodeID;
    }

    public void setCodeID(Long codeID) {
        CodeID = codeID;
    }

    public String getDiscountCode() {
        return DiscountCode;
    }

    public void setDiscountCode(String discountCode) {
        DiscountCode = discountCode;
    }

    public Double getDiscountAmount() {
        return DiscountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        DiscountAmount = discountAmount;
    }

    public LocalDate getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        ExpiryDate = expiryDate;
    }

    public Boolean getIsActive() {
        return IsActive;
    }

    public void setIsActive(Boolean isActive) {
        IsActive = isActive;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}