package com.example.drivenimbus.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long MaintenanceID;

    @ManyToOne
    @JoinColumn(name = "carID", nullable = false)
    private Car car;

    private LocalDate StartDate;
    private LocalDate EndDate;

    @Enumerated(EnumType.STRING)
    private MaintanceStatus Status;
    private String Description;

    // Default constructor
    public Maintenance() {
    }

    // Constructor with all fields
    public Maintenance(Long maintenanceID, LocalDate startDate, LocalDate endDate, MaintanceStatus status, String description) {
        MaintenanceID = maintenanceID;
        StartDate = startDate;
        EndDate = endDate;
        Status = status;
        Description = description;
    }

    public Long getMaintenanceID() {
        return MaintenanceID;
    }

    public void setMaintenanceID(Long maintenanceID) {
        MaintenanceID = maintenanceID;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }

    public MaintanceStatus getStatus() {
        return Status;
    }

    public void setStatus(MaintanceStatus status) {
        Status = status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

}