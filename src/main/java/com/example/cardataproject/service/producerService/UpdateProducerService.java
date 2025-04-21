package com.example.cardataproject.service.producerService;

import com.example.cardataproject.dto.producerDTO.ProducerResponse;
import com.example.cardataproject.entity.Producer;
import com.example.cardataproject.repository.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateProducerService {

    public ProducerRepository repository;


    public Optional<ProducerResponse> updateProducer(Integer id, String email, String phoneNumber) {

        Optional<Producer> optionalProducer = repository.updateProducer(id, email, phoneNumber);

        if (optionalProducer.isPresent()) {
            Producer producerForUpdate = optionalProducer.get();

            ProducerResponse updatedProducer = new ProducerResponse(
                    producerForUpdate.getProducerId(),
                    producerForUpdate.getName(),
                    producerForUpdate.getPhoneNumber(),
                    producerForUpdate.getEmail()
            );
            return Optional.of(updatedProducer);
        }
        return Optional.empty();

    }
}
