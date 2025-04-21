package com.example.cardataproject.service.producerService;

import com.example.cardataproject.dto.producerDTO.ProducerResponse;
import com.example.cardataproject.entity.Producer;
import com.example.cardataproject.repository.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FindProducerService {

    public ProducerRepository repository;

    public List<ProducerResponse> findAll() {
        List<Producer> allProducers = repository.findAll();

        return allProducers.stream()
                .map(currentProducer ->
                        new ProducerResponse(
                                currentProducer.getProducerId(),
                                currentProducer.getName(),
                                currentProducer.getPhoneNumber(),
                                currentProducer.getEmail()
                        ))
                .toList();
    }

    public Optional<ProducerResponse> findById(Integer id) {
        Optional<Producer> foundedProducerOptional = repository.findById(id);

        if (foundedProducerOptional.isPresent()) {
            Producer foundedProducer = foundedProducerOptional.get();

            ProducerResponse response = new ProducerResponse(
                    foundedProducer.getProducerId(),
                    foundedProducer.getName(),
                    foundedProducer.getPhoneNumber(),
                    foundedProducer.getEmail()
            );
            return Optional.of(response);
        } else {
            return Optional.empty();
        }
    }

    public List<ProducerResponse> findByName(String name) {
        List<Producer> foundedProducers = repository.findByName(name);

        return foundedProducers.stream()
                .map(currentProducer -> new ProducerResponse(
                        currentProducer.getProducerId(),
                        currentProducer.getName(),
                        currentProducer.getPhoneNumber(),
                        currentProducer.getEmail()
                ))
                .toList();
    }

    public Optional<Producer> getEntityById(Integer id) {
        return repository.findById(id);
    }

}
