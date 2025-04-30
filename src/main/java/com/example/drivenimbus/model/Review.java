package com.example.drivenimbus.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ReviewID;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    private String ReviewText;
    private Integer Rating;
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

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
}