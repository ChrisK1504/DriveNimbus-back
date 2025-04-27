package com.example.drivenimbus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Review {
    @Id
    private Long ReviewID;
    private String ReviewText;
    private int Rating;
    private Date CreatedAt;

    // Default constructor
    public Review() {
    }

    // Parameterized constructor
    public Review(Long reviewID, String reviewText, int rating, Date createdAt) {
        this.ReviewID = reviewID;
        this.ReviewText = reviewText;
        this.Rating = rating;
        this.CreatedAt = createdAt;
    }

    // Getters
    public Long getReviewID() {
        return ReviewID;
    }

    public String getReviewText() {
        return ReviewText;
    }

    public int getRating() {
        return Rating;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    // Setters
    public void setReviewID(Long reviewID) {
        this.ReviewID = reviewID;
    }

    public void setReviewText(String reviewText) {
        this.ReviewText = reviewText;
    }

    public void setRating(int rating) {
        this.Rating = rating;
    }

    public void setCreatedAt(Date createdAt) {
        this.CreatedAt = createdAt;
    }
}