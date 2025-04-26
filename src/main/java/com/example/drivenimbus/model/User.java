package com.example.drivenimbus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.swing.text.StyledEditorKit;
import java.util.Date;

enum Role {
    ADMIN,
    USER
}

@Entity
public class User {
    @Id
    private Long UserID;
    private String FullName;
    private String Email; // Unique
    private String PasswordHash;
    private String PhoneNumber;
    private String Address;
    private String ProfilePicture; // URL || file path
    private Role UserRole; // User || ADMIN
    private boolean isActive;
    private Date CreatedAt;


    public User() {
    }

    public User(Long userID, String fullName, String email, String passwordHash, String phoneNumber, String address, String profilePicture, Role userRole, boolean isActive, Date createdAt) {
        UserID = userID;
        FullName = fullName;
        Email = email;
        PasswordHash = passwordHash;
        PhoneNumber = phoneNumber;
        Address = address;
        ProfilePicture = profilePicture;
        UserRole = userRole;
        this.isActive = isActive;
        CreatedAt = createdAt;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long userID) {
        UserID = userID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String passwordHash) {
        PasswordHash = passwordHash;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getProfilePicture() {
        return ProfilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        ProfilePicture = profilePicture;
    }

    public Role getUserRole() {
        return UserRole;
    }

    public void setUserRole(Role userRole) {
        UserRole = userRole;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }
}
