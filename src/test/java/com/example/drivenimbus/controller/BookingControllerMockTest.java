package com.example.drivenimbus.controller;

import com.example.drivenimbus.model.Booking;
import com.example.drivenimbus.model.Car;
import com.example.drivenimbus.model.User;
import com.example.drivenimbus.service.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookingController.class)
public class BookingControllerMockTest {

    @MockitoBean
    private BookingService bookingService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //    HTTP Method | Endpoint | Purpose
    //POST | /bookings | Create a new booking
    //GET | /bookings | List all bookings (admin use)
    //GET | /bookings/{id} | Get a specific booking by ID
    //PUT | /bookings/{id} | Update a booking (e.g., reschedule)
    //DELETE | /bookings/{id} | Cancel/delete a booking

    private Booking booking;

    @BeforeEach
    void setUp() {
        Car car = new Car();
        car.setBrand("Toyota");
        car.setModel("Yaris");
        car.setCarID(1L);

        User user = new User();
        user.setFullName("Chris");
        user.setUserID(1L);

        booking = new Booking();
        booking.setCar(car);
        booking.setUser(user);
        booking.setBookingID(1L);
        booking.setPickupDate(LocalDate.of(2025, 5, 5));
        booking.setReturnDate(LocalDate.of(2025, 5, 10));

    }

    // Return 200 when Booking is found
    @Test
    void shouldReturnBookingByUsingId() throws Exception {

        Mockito.when(bookingService.fetchBookingById(1L)).thenReturn(booking);

        // Perform GET request on the /bookings/{id} endpoint
        mockMvc.perform(get("/bookings/{id}", 1L))
                .andExpect(status().isOk())  // Expect HTTP status 200 OK
                .andExpect(jsonPath("$.bookingID").value(1L))  // Check BookingID
                .andExpect(jsonPath("$.car.brand").value("Toyota"))  // Check car brand
                .andExpect(jsonPath("$.user.fullName").value("Chris"))  // Check user full name
                .andExpect(jsonPath("$.pickupDate").value("2025-05-05"))  // Check pickup date
                .andExpect(jsonPath("$.returnDate").value("2025-05-10"));  // Check return dat
    }

    @Test
    void shouldSaveBooking() throws Exception {
        Mockito.when(bookingService.saveBooking(booking)).thenReturn(booking);

        mockMvc.perform(post("/bookings").contentType("application/json").content(objectMapper.writeValueAsString(booking)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookingID").value(1L))
                .andExpect(jsonPath("$.car.brand").value("Toyota"))
                .andExpect(jsonPath("$.user.fullName").value("Chris"))
                .andExpect(jsonPath("$.pickupDate").value("2025-05-05"))
                .andExpect(jsonPath("$.returnDate").value("2025-05-10"));
    }

    @Test
    void shouldDeleteBooking() throws Exception {
        Long bookingId = 1L;
        mockMvc.perform(get("/bookings/{id}", bookingId))
                .andExpect(status().isOk());

        Mockito.verify(bookingService).deleteBookingById(bookingId);
    }

    @Test
    void shouldUpdateBooking() throws Exception {
        bookingService.saveBooking(booking);
        Long bookingId = 1L;
        Booking updatedBooking = new Booking();
        updatedBooking.setPickupDate(LocalDate.of(2025, 5, 15));
        updatedBooking.setReturnDate(LocalDate.of(2025, 5, 20));

        Mockito.when(bookingService.updateBooking(updatedBooking, bookingId)).thenReturn(booking);

        mockMvc.perform(put("/bookings/{id}", bookingId).contentType("application/json").content(objectMapper.writeValueAsString(updatedBooking)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookingID").value(1L))
                .andExpect(jsonPath("$.car.brand").value("Toyota"))
                .andExpect(jsonPath("$.user.fullName").value("Chris"))
                .andExpect(jsonPath("$.pickupDate").value("2025-05-15"))
                .andExpect(jsonPath("$.returnDate").value("2025-05-20"));
    }

}
