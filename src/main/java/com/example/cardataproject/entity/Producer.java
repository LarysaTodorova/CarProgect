package com.example.cardataproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer producerId;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;

    public Producer(String name, String phoneNumber, String email, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
}
