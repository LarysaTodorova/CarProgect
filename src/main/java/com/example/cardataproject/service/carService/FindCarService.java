package com.example.cardataproject.service.carService;

import com.example.cardataproject.dto.carDTO.CarResponse;
import com.example.cardataproject.dto.producerDTO.ProducerResponse;
import com.example.cardataproject.entity.Car;
import com.example.cardataproject.entity.Producer;
import com.example.cardataproject.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FindCarService {

    private CarRepository carRepository;

    public List<CarResponse> findAll() {
        List<Car> allCars = carRepository.findAll();

        return allCars.stream()
                .map(currentCar -> {
                    Producer producer = currentCar.getProducer();

                    ProducerResponse producerResponse = new ProducerResponse(
                            producer.getProducerId(),
                            producer.getName(),
                            producer.getPhoneNumber(),
                            producer.getEmail()
                    );
                    return new CarResponse(
                            currentCar.getCarId(),
                            currentCar.getModel(),
                            currentCar.getColor(),
                            currentCar.getYearOfProduction(),
                            currentCar.getEngine(),
                            currentCar.getMileage(),
                            producerResponse

                    );
                })
                .collect(Collectors.toList());
    }

    public CarResponse findById(Integer id) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            Car foundedCar = optionalCar.get();

            Producer producer = foundedCar.getProducer();

            return new CarResponse(
                    foundedCar.getCarId(),
                    foundedCar.getModel(),
                    foundedCar.getColor(),
                    foundedCar.getYearOfProduction(),
                    foundedCar.getEngine(),
                    foundedCar.getMileage(),
                    new ProducerResponse(
                            producer.getProducerId(),
                            producer.getName(),
                            producer.getPhoneNumber(),
                            producer.getEmail()
                    )
            );
        } else {
            return null;
        }
    }

    public List<CarResponse> findByProducer(Producer producer) {
        List<Car> cars = carRepository.findByProducer(producer);

        ProducerResponse producerResponse = new ProducerResponse(
                producer.getProducerId(),
                producer.getName(),
                producer.getPhoneNumber(),
                producer.getEmail()
        );

        return cars.stream()
                .map(currentCar ->
                        new CarResponse(
                                currentCar.getCarId(),
                                currentCar.getModel(),
                                currentCar.getColor(),
                                currentCar.getYearOfProduction(),
                                currentCar.getEngine(),
                                currentCar.getMileage(),
                                producerResponse

                        ))
                .collect(Collectors.toList());
    }

    public List<CarResponse> findCarByModel(String model) {
        List<Car> foundCars = carRepository.findByModel(model);

        return foundCars.stream()
                .map(currentCar -> new CarResponse(
                        currentCar.getCarId(),
                        currentCar.getModel(),
                        currentCar.getColor(),
                        currentCar.getYearOfProduction(),
                        currentCar.getEngine(),
                        currentCar.getMileage(),
                        new ProducerResponse(
                                currentCar.getProducer().getProducerId(),
                                currentCar.getProducer().getName(),
                                currentCar.getProducer().getPhoneNumber(),
                                currentCar.getProducer().getEmail()
                        )
                ))
                .toList();
    }

    public List<CarResponse> findCarByYear(Integer year) {
        List<Car> foundCars = carRepository.findByYearOfProduction(year);

        return foundCars.stream()
                .map(currentCar -> new CarResponse(
                        currentCar.getCarId(),
                        currentCar.getModel(),
                        currentCar.getColor(),
                        currentCar.getYearOfProduction(),
                        currentCar.getEngine(),
                        currentCar.getMileage(),
                        new ProducerResponse(
                                currentCar.getProducer().getProducerId(),
                                currentCar.getProducer().getName(),
                                currentCar.getProducer().getPhoneNumber(),
                                currentCar.getProducer().getEmail()
                        )
                ))
                .toList();
    }

}

