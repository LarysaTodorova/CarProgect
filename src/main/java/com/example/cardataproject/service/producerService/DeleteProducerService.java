package com.example.cardataproject.service.producerService;

import com.example.cardataproject.dto.producerDTO.ProducerResponse;
import com.example.cardataproject.entity.Producer;
import com.example.cardataproject.repository.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteProducerService {

    public ProducerRepository repository;

    public Optional<ProducerResponse> deleteProducer(Integer id) {
        Optional<Producer> deletedProducerOptional = repository.deleteProducerById(id);

        if (deletedProducerOptional.isPresent()) {
            Producer producerForDelete = deletedProducerOptional.get();
            ProducerResponse response = new ProducerResponse(
                    producerForDelete.getProducerId(),
                    producerForDelete.getName(),
                    producerForDelete.getPhoneNumber(),
                    producerForDelete.getEmail()
            );
            return Optional.of(response);
        }else {
            return Optional.empty();
        }
    }
}
