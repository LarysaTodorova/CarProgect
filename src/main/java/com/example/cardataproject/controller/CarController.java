package com.example.cardataproject.controller;


import com.example.cardataproject.dto.carDTO.CarRequest;
import com.example.cardataproject.dto.carDTO.CarResponse;
import com.example.cardataproject.entity.Producer;
import com.example.cardataproject.service.carService.AddCarService;
import com.example.cardataproject.service.carService.DeleteCarService;
import com.example.cardataproject.service.carService.FindCarService;
import com.example.cardataproject.service.carService.UpdateCarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {

    private AddCarService addCarService;
    private DeleteCarService deleteCarService;
    private FindCarService findCarService;
    private UpdateCarService updateCarService;

    @PostMapping("{id}") //localhost:8080/api/cars/1
    public CarResponse createCar(@RequestBody CarRequest request, @PathVariable Integer id) {
        return addCarService.createCar(request, id);
    }

    @GetMapping("/all") //localhost:8080/api/cars/all
    public List<CarResponse> findAllCars() {
        return findCarService.findAll();
    }

    @GetMapping("/producer") //localhost:8080/api/cars/producer?producer=Audi
    public List<CarResponse> findByProducer(@RequestParam Producer producer) {
        return findCarService.findByProducer(producer);
    }

    @GetMapping("/year") //localhost:8080/api/cars/year?year=2025
    public List<CarResponse> findByYear(@RequestParam Integer year) {
        return findCarService.findCarByYear(year);
    }

    @GetMapping("{id}")
    public Optional<CarResponse> findById(@PathVariable Integer id) {
        return Optional.ofNullable(findCarService.findById(id));
    }

    @GetMapping("/model")
    public List<CarResponse> findByModel(@RequestParam String model) {
        return findCarService.findCarByModel(model);
    }

    @DeleteMapping("{id}")
    public Optional<CarResponse> deleteCar(@PathVariable Integer id) {
        return deleteCarService.deleteCarById(id);
    }

    @PutMapping("{id}")
    public Optional<CarResponse> updateCar(@PathVariable Integer id,
                                           @RequestParam Integer year,
                                           @RequestParam Integer mileage,
                                           @RequestParam String color) {
        return updateCarService.updateCar(id, year, mileage, color);
    }
}
