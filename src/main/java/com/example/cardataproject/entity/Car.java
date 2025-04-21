package com.example.cardataproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;
    private String model;
    private String color;
    private Integer yearOfProduction;
    private String engine;
    private Integer mileage;
    @ManyToOne
    @JoinColumn(name = "producer_producer_id")
    private Producer producer;


}
