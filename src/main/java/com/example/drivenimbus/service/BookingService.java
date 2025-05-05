package com.example.drivenimbus.service;


import com.example.drivenimbus.model.Booking;
import com.example.drivenimbus.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking fetchBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    public List<Booking> fetchAllBookings() {
        return (List<Booking>) bookingRepository.findAll();
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Boolean deleteBookingById(Long bookingId) {
        if (bookingRepository.existsById(bookingId)) {
            bookingRepository.deleteById(bookingId);
            return true;
        }
        return false;
    }

    public Booking updateBooking(Booking updatedBooking, Long bookingId) {
        return bookingRepository.findById(bookingId).map(booking -> {
            booking.setPickupDate(updatedBooking.getPickupDate());
            booking.setReturnDate(updatedBooking.getReturnDate());
            return bookingRepository.save(booking);
        }).orElse(null);
    }

    public List<Booking> fetchBookingsByUserId(Long userId) {
        return bookingRepository.findByUserUserID(userId);
    }

    public List<Booking> fetchBookingsByUserIdAndUpcoming(Long userId) {
        return bookingRepository.findByUserUserIDAndPickupDateAfter(userId, java.time.LocalDate.now());
    }
}
