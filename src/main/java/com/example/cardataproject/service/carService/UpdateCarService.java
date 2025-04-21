package com.example.cardataproject.service.carService;

import com.example.cardataproject.dto.carDTO.CarResponse;
import com.example.cardataproject.dto.producerDTO.ProducerResponse;
import com.example.cardataproject.entity.Car;
import com.example.cardataproject.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateCarService {

    private CarRepository carRepository;

    public Optional<CarResponse> updateCar(Integer carId, Integer year, Integer mileage, String color) {

        return carRepository.updateCar(carId, year, mileage, color)
                .map(carForUpdate -> new CarResponse(
                        carForUpdate.getCarId(),
                        carForUpdate.getModel(),
                        carForUpdate.getColor(),
                        carForUpdate.getYearOfProduction(),
                        carForUpdate.getEngine(),
                        carForUpdate.getMileage(),
                        new ProducerResponse(
                                carForUpdate.getProducer().getProducerId(),
                                carForUpdate.getProducer().getName(),
                                carForUpdate.getProducer().getPhoneNumber(),
                                carForUpdate.getProducer().getEmail()
                        ))
                );
    }
}
