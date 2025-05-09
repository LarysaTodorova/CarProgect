package com.example.cardataproject.repository;

import com.example.cardataproject.dto.carDTO.CarResponse;
import com.example.cardataproject.entity.Car;
import com.example.cardataproject.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByProducer(Producer producer);

    List<Car> findByModel(String model);


    List<Car> findByYearOfProduction(Integer yearOfProduction);

    default Optional<Car> deleteCarByCarId(Integer carId) {
        Optional<Car> optionalCar = findById(carId);

        optionalCar.ifPresent(this::delete);
        return optionalCar;
    }

    default Optional<Car> updateCar(Integer carId, Integer year, Integer mileage, String color) {
        Optional<Car> optionalCar = findById(carId);

        if (optionalCar.isPresent()) {
            Car carForUpdate = optionalCar.get();
            carForUpdate.setColor(color);
            carForUpdate.setYearOfProduction(year);
            carForUpdate.setMileage(mileage);
            return Optional.of(save(carForUpdate));
        }
        return Optional.empty();
    }
   
}
