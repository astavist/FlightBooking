package com.turkcell.userservice.business.abstracts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<GetAllAirlinesResponse> getAll();

    GetAirlineResponse getById(UUID id);

    CreateAirlineResponse add(CreateAirlineRequest request);

    UpdateAirlineResponse update(UUID id, UpdateAirlineRequest request);

    void delete(UUID id);
}
