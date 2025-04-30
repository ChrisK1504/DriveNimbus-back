package com.example.drivenimbus.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long PaymentID;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    private double Amount;

    @Enumerated(EnumType.STRING)
    private Method PaymentMethod;
    @Enumerated(EnumType.STRING)
    private PayStatus PaymentStatus;
    private Date PaidAt;

    // Default constructor
    public Payment() {
    }

    // Parameterized constructor
    public Payment(Long paymentID, Booking booking, Double amount,
                  Method paymentMethod, PayStatus paymentStatus, Date paidAt) {
        this.PaymentID = paymentID;
        this.booking = booking;
        this.Amount = amount;
        this.PaymentMethod = paymentMethod;
        this.PaymentStatus = paymentStatus;
        this.PaidAt = paidAt;
    }

    // Getters
    public Long getPaymentID() {
        return PaymentID;
    }

    public Booking getBooking() {
        return booking;
    }

    public double getAmount() {
        return Amount;
    }

    public Method getPaymentMethod() {
        return PaymentMethod;
    }

    public PayStatus getPaymentStatus() {
        return PaymentStatus;
    }

    public Date getPaidAt() {
        return PaidAt;
    }

    // Setters
    public void setPaymentID(Long paymentID) {
        this.PaymentID = paymentID;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setAmount(double amount) {
        this.Amount = amount;
    }

    public void setPaymentMethod(Method paymentMethod) {
        this.PaymentMethod = paymentMethod;
    }

    public void setPaymentStatus(PayStatus paymentStatus) {
        this.PaymentStatus = paymentStatus;
    }

    public void setPaidAt(Date paidAt) {
        this.PaidAt = paidAt;
    }
}