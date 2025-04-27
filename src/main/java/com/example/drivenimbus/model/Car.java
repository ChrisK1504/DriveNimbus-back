package com.example.drivenimbus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

enum Fuel {
    GASOLINE,
    DIESEL,
    ELECTRIC
}

enum State {
    AVAILABLE,
    BOOKED,
    MAINTENANCE
}

@Entity
public class Car {
    @Id
    private Long CarID;
    private String Brand;
    private String Model;
    private int Year;
    private Fuel FuelType;
    private int Mileage;
    private double Price;
    private State Status;
    private String ImageURL;
    private String Description;

    // Default constructor
    public Car() {
    }

    // Parameterized constructor
    public Car(Long carID, String brand, String model, int year, Fuel fuelType, 
               int mileage, double price, State status, String imageURL, String description) {
        this.CarID = carID;
        this.Brand = brand;
        this.Model = model;
        this.Year = year;
        this.FuelType = fuelType;
        this.Mileage = mileage;
        this.Price = price;
        this.Status = status;
        this.ImageURL = imageURL;
        this.Description = description;
    }

    // Getters
    public Long getCarID() {
        return CarID;
    }

    public String getBrand() {
        return Brand;
    }

    public String getModel() {
        return Model;
    }

    public int getYear() {
        return Year;
    }

    public Fuel getFuelType() {
        return FuelType;
    }

    public int getMileage() {
        return Mileage;
    }

    public double getPrice() {
        return Price;
    }

    public State getStatus() {
        return Status;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public String getDescription() {
        return Description;
    }

    // Setters
    public void setCarID(Long carID) {
        this.CarID = carID;
    }

    public void setBrand(String brand) {
        this.Brand = brand;
    }

    public void setModel(String model) {
        this.Model = model;
    }

    public void setYear(int year) {
        this.Year = year;
    }

    public void setFuelType(Fuel fuelType) {
        this.FuelType = fuelType;
    }

    public void setMileage(int mileage) {
        this.Mileage = mileage;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    public void setStatus(State status) {
        this.Status = status;
    }

    public void setImageURL(String imageURL) {
        this.ImageURL = imageURL;
    }

    public void setDescription(String description) {
        this.Description = description;
    }
}