package com.example.drivenimbus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

enum Method {
    CASH,
    CREDIT_CARD,
    DEBIT_CARD,
    PAYPAL,
}

enum PayStatus {
    SUCCESS,
    FAILED
}

@Entity
public class Payment {
    @Id
    private Long PaymentID;
    private Long BookingID;
    private double Amount;
    private Method PaymentMethod;
    private PayStatus PaymentStatus;
    private Date PaidAt;

    // Default constructor
    public Payment() {
    }

    // Parameterized constructor
    public Payment(Long paymentID, Long bookingID, double amount, 
                  Method paymentMethod, PayStatus paymentStatus, Date paidAt) {
        this.PaymentID = paymentID;
        this.BookingID = bookingID;
        this.Amount = amount;
        this.PaymentMethod = paymentMethod;
        this.PaymentStatus = paymentStatus;
        this.PaidAt = paidAt;
    }

    // Getters
    public Long getPaymentID() {
        return PaymentID;
    }

    public Long getBookingID() {
        return BookingID;
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

    public void setBookingID(Long bookingID) {
        this.BookingID = bookingID;
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