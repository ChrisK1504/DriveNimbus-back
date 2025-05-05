package com.example.drivenimbus.controller;

import com.example.drivenimbus.model.Car;
import com.example.drivenimbus.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired private CarService carService;

    @Operation(summary = "Get all cars")
    @GetMapping
    public List<Car> getAllCars() {
        return carService.fetchCarList();
    }

    @Operation(summary = "Get a specific car by ID")
    @GetMapping("/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable Long carId) {
        Car car = carService.fetchCarById(carId);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete a car by ID // ADMIN")
    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long carId) {
        if (carService.deleteCarById(carId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Add a new car // ADMIN")
    @PostMapping
    public Car saveCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @Operation(summary = "Update a car // ADMIN")
    @PutMapping("/{carId}")
    public ResponseEntity<Car> updateCar(@RequestBody Car updatedCar, @PathVariable Long carId) {
        Car car = carService.updateCar(updatedCar, carId);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }

}
