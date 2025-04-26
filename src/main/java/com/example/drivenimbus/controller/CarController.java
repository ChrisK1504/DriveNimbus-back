package com.example.drivenimbus.controller;

import com.example.drivenimbus.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cars")
public class CarController {
    @GetMapping
    public Car getCar() {
        return new Car(1L, "Megan", "Benz");
    }
}
