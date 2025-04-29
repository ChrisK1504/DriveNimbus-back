package com.example.drivenimbus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.util.Date;

enum MaintanceStatus {
    SCHEDULED,
    COMPLETED
}

@Entity
public class Maintenance {
    @Id
    private Long MaintenanceID;
    private Date StartDate;
    private Date EndDate;
    @Enumerated(EnumType.STRING)
    private MaintanceStatus Status;
    private String Description;

    // Default constructor
    public Maintenance() {
    }

    // Constructor with all fields
    public Maintenance(Long maintenanceID, Date startDate, Date endDate, MaintanceStatus status, String description) {
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

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
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
}