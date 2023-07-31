package com.turkcell.flightsservice.business.abstracts;

import com.turkcell.flightsservice.business.dto.requests.create.CreateAirlineRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdateAirlineRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreateAirlineResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetAirlineResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllAirlinesResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdateAirlineResponse;

import java.util.List;
import java.util.UUID;

public interface AirlineService {
    List<GetAllAirlinesResponse> getAll();

    GetAirlineResponse getById(UUID id);

    CreateAirlineResponse add(CreateAirlineRequest request);

    UpdateAirlineResponse update(UUID id, UpdateAirlineRequest request);

    void delete(UUID id);
}
