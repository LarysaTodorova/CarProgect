package com.example.cardataproject.service.carService;

import com.example.cardataproject.dto.carDTO.CarRequest;
import com.example.cardataproject.dto.carDTO.CarResponse;
import com.example.cardataproject.dto.producerDTO.ProducerResponse;
import com.example.cardataproject.entity.Car;
import com.example.cardataproject.entity.Producer;
import com.example.cardataproject.repository.CarRepository;
import com.example.cardataproject.service.producerService.FindProducerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class AddCarService {

    public CarRepository carRepository;
    public FindProducerService producerService;

    public CarResponse createCar(CarRequest request, Integer id) {
        Optional<Producer> optionalProducer = producerService.getEntityById(id);

        if (optionalProducer.isPresent()) {
            Producer producer = optionalProducer.get();

            Car carBeforeCreating = new Car(
                    null,
                    request.getModel(),
                    request.getColor(),
                    request.getYearOfProduction(),
                    request.getEngine(),
                    request.getMileage(),
                    producer
            );

            Car createdCar = carRepository.save(carBeforeCreating);

            return new CarResponse(
                    createdCar.getCarId(),
                    createdCar.getModel(),
                    createdCar.getColor(),
                    createdCar.getYearOfProduction(),
                    createdCar.getEngine(),
                    createdCar.getMileage(),
                    new ProducerResponse(
                            producer.getProducerId(),
                            producer.getName(),
                            producer.getPhoneNumber(),
                            producer.getEmail()
                    )
            );
        }
        return null;
    }
}
