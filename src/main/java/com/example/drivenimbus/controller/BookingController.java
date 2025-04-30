package com.example.drivenimbus.controller;

import com.example.drivenimbus.model.Booking;
import com.example.drivenimbus.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

//    HTTP Method | Endpoint | Purpose
//    POST | /bookings | Create a new booking
//    GET | /bookings | List all bookings (admin use)
//    GET | /bookings/{id} | Get a specific booking by ID
//    PUT | /bookings/{id} | Update a booking (e.g., reschedule)
//    DELETE | /bookings/{id} | Cancel/delete a booking

    @Operation(summary = "Get all bookings")
    @GetMapping
    public ResponseEntity<Iterable<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.fetchAllBookings());
    }

    @Operation(summary = "Get a specific booking by ID")
    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
        Booking booking = bookingService.fetchBookingById(bookingId);
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }


    @Operation(summary = "Create a new booking (User ID not needed as you are supplying the User data completely")
    @PostMapping
    public ResponseEntity<Booking> createBooking(@Validated @RequestBody Booking booking) {
        bookingService.saveBooking(booking);
        return ResponseEntity.ok(booking);
    }

    @Operation(summary = "Cancel/delete a booking")
    @DeleteMapping("/bookings/{bookingId}")
    public ResponseEntity<Booking> deleteBookingById(@PathVariable Long bookingId) {
        if (bookingService.deleteBookingById(bookingId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Update a booking (e.g., reschedule)")
    @PutMapping("/bookings/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long bookingId, @Validated @RequestBody Booking updatedBooking) {
        Booking booking = bookingService.updateBooking(updatedBooking, bookingId);
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }

//    HTTP Method | Endpoint | Purpose
//    GET | /users/{userId}/bookings | List bookings for a specific user
//    GET | /users/{userId}/bookings/upcoming | View only future bookings

    @Operation(summary = "List bookings for a specific user")
    @GetMapping("/users/{userId}/bookings")
    public ResponseEntity<Iterable<Booking>> getBookingsByUserId(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.fetchBookingsByUserId(userId);
        return bookings.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(bookings);
    }


    @GetMapping("/users/{userId}/bookings/upcoming")
    public ResponseEntity<Iterable<Booking>> getBookingsByUserIdAndUpcoming(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.fetchBookingsByUserIdAndUpcoming(userId);
        return bookings.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(bookings);
    }


}
