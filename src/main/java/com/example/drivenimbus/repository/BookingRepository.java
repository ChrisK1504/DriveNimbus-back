package com.example.drivenimbus.repository;

import com.example.drivenimbus.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserUserID(Long userId);
    List<Booking> findByUserUserIDAndPickupDateAfter(Long userId, LocalDate today);

}
