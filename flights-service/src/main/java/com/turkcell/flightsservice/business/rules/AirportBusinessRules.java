package com.turkcell.flightsservice.business.rules;

import com.turkcell.flightsservice.repository.AirlineRepository;
import com.turkcell.flightsservice.repository.AirportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AirportBusinessRules {
    private final AirportRepository repository;

    public void checkIfAirportExist(UUID id){
        if (!repository.existsById(id)) {
            throw new RuntimeException("AIRPORT_NOT_EXISTS");
        }
    }
}
