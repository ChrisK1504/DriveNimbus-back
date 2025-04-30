package com.example.drivenimbus.controller;

import com.example.drivenimbus.model.Booking;
import com.example.drivenimbus.service.BookingService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<Iterable<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.fetchAllBookings());
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
        Booking booking = bookingService.fetchBookingById(bookingId);
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@Validated @RequestBody Booking booking) {
        bookingService.saveBooking(booking);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Booking> deleteBookingById(@PathVariable Long bookingId) {
        if (bookingService.deleteBookingById(bookingId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long bookingId, @Validated @RequestBody Booking updatedBooking) {
        Booking booking = bookingService.updateBooking(updatedBooking, bookingId);
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }

//    HTTP Method | Endpoint | Purpose
//    GET | /users/{userId}/bookings | List bookings for a specific user
//    GET | /users/{userId}/bookings/upcoming | View only future bookings

//    @GetMapping("/users/{userId}/bookings")
//    public ResponseEntity<Iterable<Booking>> getBookingsByUserId(@PathVariable Long userId) {
//        List<Booking> bookings = bookingService.fetchBookingsByUserId(userId);
//        return bookings.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(bookings);
//    }
//
//    @GetMapping("/users/{userId}/bookings/upcoming")
//    public ResponseEntity<Iterable<Booking>> getBookingsByUserIdAndUpcoming(@PathVariable Long userId) {
//        List<Booking> bookings = bookingService.fetchBookingsByUserIdAndUpcoming(userId);
//        return bookings.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(bookings);
//    }


}
