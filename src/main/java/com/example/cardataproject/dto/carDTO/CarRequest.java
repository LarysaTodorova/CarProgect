package com.example.cardataproject.dto.carDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {

    private String model;
    private String color;
    private Integer yearOfProduction;
    private String engine;
    private Integer mileage;

}
