package com.example.drivenimbus.config;

import com.example.drivenimbus.model.*;
import com.example.drivenimbus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private DiscountCodeRepository discountCodeRepository;

    public void run(String... args) {
        seedUsers();
        seedCars();
        seedBookings();
        seedMaintenance();
        seedPayments();
        seedReviews();
        seedDiscountCodes();
    }

    private void seedUsers() {
        Users user1 = new Users();
        user1.setFullName("John Doe");
        user1.setEmail("john.doe@example.com");
        user1.setPasswordHash("password_hash_1");
        user1.setPhoneNumber("1234567890");
        user1.setAddress("123 Main St");
        user1.setProfilePicture("https://randomuser.me/api/portraits/women/1.jpg");
        user1.setUserRole(Role.USER);
        user1.setActive(true);
        user1.setCreatedAt(new Date());
        user1.setEmailVerified(true);
        userRepository.save(user1);

        Users user2 = new Users();
        user2.setFullName("Jane Smith");
        user2.setEmail("jane.smith@example.com");
        user2.setPasswordHash("password_hash_2");
        user2.setPhoneNumber("0987654321");
        user2.setAddress("456 Elm St");
        user2.setProfilePicture("https://randomuser.me/api/portraits/men/2.jpg");
        user2.setUserRole(Role.ADMIN);
        user2.setActive(true);
        user2.setCreatedAt(new Date());
        user2.setEmailVerified(true);
        userRepository.save(user2);
    }

    private void seedCars() {
        Car car1 = new Car();
        car1.setBrand("Toyota");
        car1.setModel("Camry");
        car1.setYear(2020);
        car1.setFuelType(Fuel.PETROL);
        car1.setMileage(15000);
        car1.setPrice(25000.00);
        car1.setStatus(State.AVAILABLE);
        car1.setImageURL("https://cdn.pixabay.com/photo/2015/01/19/13/51/car-604019_1280.jpg");
        car1.setDescription("A reliable sedan with great fuel economy.");
        carRepository.save(car1);

        Car car2 = new Car();
        car2.setBrand("Honda");
        car2.setModel("Civic");
        car2.setYear(2021);
        car2.setFuelType(Fuel.DIESEL);
        car2.setMileage(10000);
        car2.setPrice(22000.00);
        car2.setStatus(State.AVAILABLE);
        car2.setImageURL("https://cdn.pixabay.com/photo/2016/11/29/09/32/tesla-1868661_1280.jpg");
        car2.setDescription("A compact car with excellent handling.");
        carRepository.save(car2);
    }

    private void seedBookings() {
        Booking booking1 = new Booking();
        booking1.setUser(userRepository.findById(1L).orElseThrow());
        booking1.setCar(carRepository.findById(1L).orElseThrow());
        booking1.setPickupDate(java.sql.Date.valueOf("2023-05-01").toLocalDate());
        booking1.setReturnDate(java.sql.Date.valueOf("2023-05-07").toLocalDate());
        booking1.setBookingStatus(Status.CONFIRMED);
        booking1.setCreatedAt(new Date());
        bookingRepository.save(booking1);

        Booking booking2 = new Booking();
        booking2.setUser(userRepository.findById(2L).orElseThrow());
        booking2.setCar(carRepository.findById(2L).orElseThrow());
        booking2.setPickupDate(java.sql.Date.valueOf("2023-06-15").toLocalDate());
        booking2.setReturnDate(java.sql.Date.valueOf("2023-06-20").toLocalDate());
        booking2.setBookingStatus(Status.PENDING);
        booking2.setCreatedAt(new Date());
        bookingRepository.save(booking2);
    }

    private void seedMaintenance() {
        Maintenance maintenance = new Maintenance();
        maintenance.setCar(carRepository.findById(1L).orElseThrow());
        maintenance.setStartDate(java.sql.Date.valueOf("2023-04-01").toLocalDate());
        maintenance.setEndDate(java.sql.Date.valueOf("2023-04-05").toLocalDate());
        maintenance.setStatus(MaintanceStatus.COMPLETED);
        maintenance.setDescription("Oil change and tire check.");
        maintenanceRepository.save(maintenance);
    }

    private void seedPayments() {
        Payment payment1 = new Payment();
        payment1.setBooking(bookingRepository.findById(1L).orElseThrow());
        payment1.setAmount(200.00);
        payment1.setPaymentMethod(Method.CREDIT_CARD);
        payment1.setPaymentStatus(PayStatus.SUCCESS);
        payment1.setPaidAt(java.sql.Date.valueOf("2023-05-01"));
        paymentRepository.save(payment1);

        Payment payment2 = new Payment();
        payment2.setBooking(bookingRepository.findById(2L).orElseThrow());
        payment2.setAmount(180.00);
        payment2.setPaymentMethod(Method.CASH);
        payment2.setPaymentStatus(PayStatus.FAILED);
        payment2.setPaidAt(java.sql.Date.valueOf("2023-06-15"));
        paymentRepository.save(payment2);
    }

    private void seedReviews() {
        Review review1 = new Review();
        review1.setCar(carRepository.findById(1L).orElseThrow());
        review1.setUser(userRepository.findById(1L).orElseThrow());
        review1.setReviewText("Great car, smooth drive!");
        review1.setRating(5);
        review1.setCreatedAt(new Date());
        reviewRepository.save(review1);

        Review review2 = new Review();
        review2.setCar(carRepository.findById(2L).orElseThrow());
        review2.setUser(userRepository.findById(2L).orElseThrow());
        review2.setReviewText("The Civic is a good choice for city driving.");
        review2.setRating(4);
        review2.setCreatedAt(new Date());
        reviewRepository.save(review2);
    }

    private void seedDiscountCodes() {
        DiscountCode discountCode1 = new DiscountCode();
        discountCode1.setBooking(bookingRepository.findById(1L).orElseThrow());
        discountCode1.setDiscountCode("DISCOUNT10");
        discountCode1.setDiscountAmount(10.00);
        discountCode1.setExpiryDate(java.sql.Date.valueOf("2023-06-30").toLocalDate());
        discountCode1.setIsActive(true);
        discountCodeRepository.save(discountCode1);

        DiscountCode discountCode2 = new DiscountCode();
        discountCode2.setBooking(bookingRepository.findById(2L).orElseThrow());
        discountCode2.setDiscountCode("DISCOUNT15");
        discountCode2.setDiscountAmount(15.00);
        discountCode2.setExpiryDate(java.sql.Date.valueOf("2023-07-15").toLocalDate());
        discountCode2.setIsActive(true);
        discountCodeRepository.save(discountCode2);
    }
}
