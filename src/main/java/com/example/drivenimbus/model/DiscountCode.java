package com.example.drivenimbus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class DiscountCode {
    @Id
    private Long CodeID;
    private String DiscountCode;
    private Double DiscountAmount;
    private Date ExpiryDate;
    private Boolean IsActive;

    // Default constructor
    public DiscountCode() {
    }

    // Constructor with all fields
    public DiscountCode(Long codeID, String discountCode, Double discountAmount, Date expiryDate, Boolean isActive) {
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

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        ExpiryDate = expiryDate;
    }

    public Boolean getIsActive() {
        return IsActive;
    }

    public void setIsActive(Boolean isActive) {
        IsActive = isActive;
    }
}