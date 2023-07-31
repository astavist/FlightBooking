package com.turkcell.flightsservice.business.abstracts;

import com.turkcell.flightsservice.business.dto.requests.create.CreateFlightRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdateFlightRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreateFlightResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetFlightResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllFlightsResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdateFlightResponse;

import java.util.List;
import java.util.UUID;

public interface FlightService {
    List<GetAllFlightsResponse> getAll();

    GetFlightResponse getById(UUID id);

    CreateFlightResponse add(CreateFlightRequest request);

    UpdateFlightResponse update(UUID id, UpdateFlightRequest request);

    void delete(UUID id);
}



