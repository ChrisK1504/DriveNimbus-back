package com.example.drivenimbus.controller;

import com.example.drivenimbus.model.Car;
import com.example.drivenimbus.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {
    @Autowired private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.fetchCarList();
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable Long carId) {
        Car car = carService.fetchCarById(carId);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long carId) {
        if (carService.deleteCarById(carId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Car saveCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @PutMapping("/{carId}")
    public ResponseEntity<Car> updateCar(@RequestBody Car updatedCar, @PathVariable Long carId) {
        Car car = carService.updateCar(updatedCar, carId);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }

}
