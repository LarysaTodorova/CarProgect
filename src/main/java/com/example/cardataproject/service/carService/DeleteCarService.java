package com.example.cardataproject.service.carService;

import com.example.cardataproject.dto.carDTO.CarResponse;
import com.example.cardataproject.dto.producerDTO.ProducerResponse;
import com.example.cardataproject.entity.Car;
import com.example.cardataproject.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteCarService {

    private CarRepository carRepository;

    public Optional<CarResponse> deleteCarById(Integer carId) {

        Optional<Car> optionalCar = carRepository.findById(carId);

        if (optionalCar.isPresent()) {
            Car foundcar = optionalCar.get();
            carRepository.deleteCarByCarId(carId);

            ProducerResponse producerResponse = new ProducerResponse(
                    foundcar.getProducer().getProducerId(),
                    foundcar.getProducer().getName(),
                    foundcar.getProducer().getPhoneNumber(),
                    foundcar.getProducer().getEmail()
            );

            CarResponse response = new CarResponse(
                    foundcar.getCarId(),
                    foundcar.getModel(),
                    foundcar.getColor(),
                    foundcar.getYearOfProduction(),
                    foundcar.getEngine(),
                    foundcar.getMileage(),
                    producerResponse
            );
            return Optional.of(response);
        }else {
            return Optional.empty();
        }
    }
}
