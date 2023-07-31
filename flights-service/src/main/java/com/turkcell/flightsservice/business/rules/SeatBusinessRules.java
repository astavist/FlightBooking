package com.turkcell.flightsservice.business.rules;

import com.turkcell.flightsservice.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SeatBusinessRules {
    private final SeatRepository repository;

    public void checkIfSeatExists(UUID id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("SEAT_NOT_EXISTS");
        }
    }
}
