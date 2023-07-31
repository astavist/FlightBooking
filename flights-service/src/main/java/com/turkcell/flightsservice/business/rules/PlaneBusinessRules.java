package com.turkcell.flightsservice.business.rules;

import com.turkcell.flightsservice.repository.PlaneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PlaneBusinessRules {
    private final PlaneRepository repository;

    public void checkIfPlaneExist(UUID id){
        if (!repository.existsById(id)) {
            throw new RuntimeException("PLANE_NOT_EXISTS");
        }
    }
}
