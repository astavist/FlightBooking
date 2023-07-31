package com.turkcell.flightsservice.business.rules;

import com.turkcell.flightsservice.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FlightBusinessRules {
    private final FlightRepository repository;
    public void checkIfFlightExist(UUID id){
        if (!repository.existsById(id)) {
            throw new RuntimeException("FLIGHT_NOT_EXISTS");
        }
    }
}
