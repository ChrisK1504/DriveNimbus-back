package com.example.drivenimbus.config;

import com.example.drivenimbus.model.*;
import com.example.drivenimbus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired private CarRepository carRepository;
    @Autowired private BookingRepository bookingRepository;
    @Autowired private PaymentRepository paymentRepository;
    @Autowired private ReviewRepository reviewRepository;
    @Autowired private DiscountCodeRepository discountCodeRepository;
    @Autowired private MaintenanceRepository maintenanceRepository;

    @Override
    public void run(String... args) {
        seedUsers();
        seedCars();
        seedBookings();
        seedPayments();
        seedReviews();
        seedDiscountCodes();
        seedMaintenance();
    }

    private void seedUsers() {
        for (int i = 1; i <= 20; i++) {
            Users user = new Users();
            user.setFullName("User " + i);
            user.setEmail("user" + i + "@mail.com");
            user.setPasswordHash("hash" + i);
            user.setPhoneNumber("10000000" + i);
            user.setAddress("Address " + i);
            user.setUserRole(Role.USER);
            user.setActive(true);
            user.setCreatedAt(new Date());
            userRepository.save(user);
        }
    }

    private void seedCars() {
        for (int i = 1; i <= 20; i++) {
            Car car = new Car();
            car.setBrand("Brand " + i);
            car.setModel("Model " + i);
            car.setYear(2020 + (i % 5));
            car.setFuelType(Fuel.GASOLINE);
            car.setMileage(10000 + i * 100);
            car.setPrice(50.0 + i);
            car.setStatus(State.AVAILABLE);
            car.setImageURL("http://example.com/car" + i + ".jpg");
            car.setDescription("Description for car " + i);
            carRepository.save(car);
        }
    }

    private void seedBookings() {
        List<Users> users = userRepository.findAll();
        List<Car> cars = carRepository.findAll();
        for (int i = 1; i <= 20; i++) {
            Booking booking = new Booking();
            booking.setUser(users.get(i % users.size()));
            booking.setCar(cars.get(i % cars.size()));
            booking.setPickupDate(LocalDate.now().plusDays(i));
            booking.setReturnDate(LocalDate.now().plusDays(i + 5));
            booking.setBookingStatus(Status.CONFIRMED);
            booking.setCreatedAt(new Date());
            bookingRepository.save(booking);
        }
    }

    private void seedPayments() {
        List<Booking> bookings = bookingRepository.findAll();
        for (int i = 1; i <= 20; i++) {
            Payment payment = new Payment();
            payment.setBooking(bookings.get(i % bookings.size()));
            payment.setAmount(100.0 + i);
            payment.setPaymentMethod(Method.CASH);
            payment.setPaymentStatus(PayStatus.SUCCESS);
            payment.setPaidAt(new Date());
            paymentRepository.save(payment);
        }
    }

    private void seedReviews() {
        List<Users> users = userRepository.findAll();
        List<Car> cars = carRepository.findAll();
        for (int i = 1; i <= 20; i++) {
            Review review = new Review();
            review.setUser(users.get(i % users.size()));
            review.setCar(cars.get(i % cars.size()));
            review.setRating((i % 5) + 1);
            review.setReviewText("Review " + i);
            review.setCreatedAt(new Date());
            reviewRepository.save(review);
        }
    }

    private void seedDiscountCodes() {
        List<Booking> bookings = bookingRepository.findAll();
        for (int i = 1; i <= 20; i++) {
            DiscountCode code = new DiscountCode();
            code.setDiscountCode("CODE" + i);
            code.setDiscountAmount(5.0 + i);
            code.setExpiryDate(LocalDate.now().plusDays(30));
            code.setIsActive(true);
            code.setBooking(bookings.get(i % bookings.size()));
            discountCodeRepository.save(code);
        }
    }

    private void seedMaintenance() {
        List<Car> cars = carRepository.findAll();
        for (int i = 1; i <= 20; i++) {
            Maintenance m = new Maintenance();
            m.setCar(cars.get(i % cars.size()));
            m.setStartDate(LocalDate.now().minusDays(i * 2));
            m.setEndDate(LocalDate.now().minusDays(i));
            m.setStatus(MaintanceStatus.SCHEDULED);
            m.setDescription("Routine check " + i);
            maintenanceRepository.save(m);
        }
    }
}

