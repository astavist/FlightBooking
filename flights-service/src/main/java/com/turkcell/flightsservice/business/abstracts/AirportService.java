package com.turkcell.flightsservice.business.abstracts;

import com.turkcell.flightsservice.business.dto.requests.create.CreateAirportRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdateAirportRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreateAirportResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetAirportResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllAirportsResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdateAirportResponse;

import java.util.List;
import java.util.UUID;

public interface AirportService {
    List<GetAllAirportsResponse> getAll();

    GetAirportResponse getById(UUID id);

    CreateAirportResponse add(CreateAirportRequest request);

    UpdateAirportResponse update(UUID id, UpdateAirportRequest request);

    void delete(UUID id);
}
