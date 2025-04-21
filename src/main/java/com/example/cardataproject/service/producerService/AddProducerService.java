package com.example.cardataproject.service.producerService;

import com.example.cardataproject.dto.producerDTO.ProducerRequest;
import com.example.cardataproject.dto.producerDTO.ProducerResponse;
import com.example.cardataproject.entity.Producer;
import com.example.cardataproject.repository.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddProducerService {

    public ProducerRepository repository;

    public ProducerResponse createProducer(ProducerRequest request) {
        Producer producerBeforeCreating = new Producer(
                request.getName(),
                request.getPhoneNumber(),
                request.getEmail(),
                request.getPassword()
        );

        Producer savedProducer = repository.save(producerBeforeCreating);
        return new ProducerResponse(
                savedProducer.getProducerId(),
                savedProducer.getName(),
                savedProducer.getPhoneNumber(),
                savedProducer.getEmail()
        );
    }
}
