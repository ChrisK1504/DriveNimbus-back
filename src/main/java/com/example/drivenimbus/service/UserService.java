package com.example.drivenimbus.service;

import com.example.drivenimbus.model.Users;
import com.example.drivenimbus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> fetchAllUsers() {
        return (List<Users>) userRepository.findAll();
    }

    public Users fetchUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public Boolean deleteUserById(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public Users updateUser(Long userId, Users updatedUser) {
        return userRepository.findById(userId).map(user -> {
            user.setFullName(updatedUser.getFullName());
            user.setEmail(updatedUser.getEmail());
            user.setPasswordHash(updatedUser.getPasswordHash());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            user.setAddress(updatedUser.getAddress());
            user.setProfilePicture(updatedUser.getProfilePicture());
            user.setUserRole(updatedUser.getUserRole());
            user.setActive(updatedUser.isActive());
            user.setCreatedAt(updatedUser.getCreatedAt());
            return userRepository.save(user);
        }).orElse(null);
    }
}
