package com.example.drivenimbus.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ReviewID;

    @ManyToOne
//    @JoinColumn(name = "carID", nullable = false)
    private Car car;

    @ManyToOne
//    @JoinColumn(name = "userID", nullable = false)
    private Users user;

    private String reviewText;
    private Integer rating;
    private Date createdAt;

    // Default constructor
    public Review() {
    }

    // Parameterized constructor
    public Review(Long reviewID, String reviewText, int rating) {
        this.ReviewID = reviewID;
        this.reviewText = reviewText;
        this.rating = rating;
        this.createdAt = new Date();
    }

    // Getters
    public Long getReviewID() {
        return ReviewID;
    }

    public String getReviewText() {
        return reviewText;
    }

    public int getRating() {
        return rating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setReviewID(Long reviewID) {
        this.ReviewID = reviewID;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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