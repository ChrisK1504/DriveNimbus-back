package com.example.drivenimbus.service;


import com.example.drivenimbus.model.Booking;
import com.example.drivenimbus.model.Car;
import com.example.drivenimbus.model.State;
import com.example.drivenimbus.model.Status;
import com.example.drivenimbus.repository.BookingRepository;
import com.example.drivenimbus.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;

    public Booking fetchBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    public List<Booking> fetchAllBookings() {
        return (List<Booking>) bookingRepository.findAll();
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // TODO COME BACK TO THIS WHEN PAYMENT ENTITY BECOMES IMPORTANT
    public Boolean cancelBooking(Booking booking) {
        if (booking.getPickupDate().isAfter(java.time.LocalDate.now())) {
            updateCarAvailability(booking.getCar());

            booking.setBookingStatus(Status.CANCELLED);
            return bookingRepository.save(booking) != null;
        }
        return false;
    }

    private void updateCarAvailability(Car car) {
        car.setStatus(State.AVAILABLE);
        carRepository.save(car);
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
