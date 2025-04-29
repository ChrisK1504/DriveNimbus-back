package com.example.drivenimbus.controller;

import com.example.drivenimbus.model.Booking;
import com.example.drivenimbus.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

//    HTTP Method | Endpoint | Purpose
//    POST | /bookings | Create a new booking
//    GET | /bookings | List all bookings (admin use)
//    GET | /bookings/{id} | Get a specific booking by ID
//    PUT | /bookings/{id} | Update a booking (e.g., reschedule)
//    DELETE | /bookings/{id} | Cancel/delete a booking

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
        Booking booking = bookingService.fetchBookingById(bookingId);
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }

}
