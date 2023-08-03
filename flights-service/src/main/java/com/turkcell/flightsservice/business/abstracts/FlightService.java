package com.turkcell.flightsservice.business.abstracts;

import com.turkcell.commonpackage.utils.dto.ClientResponse;
import com.turkcell.flightsservice.business.dto.requests.create.CreateFlightRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdateFlightRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreateFlightResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetFlightResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllFlightsResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdateFlightResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface FlightService {
    List<GetAllFlightsResponse> getAll();

    GetFlightResponse getById(UUID id);

    CreateFlightResponse add(CreateFlightRequest request);

    UpdateFlightResponse update(UUID id, UpdateFlightRequest request);
    ClientResponse checkFlightIsValid(UUID id);

    void delete(UUID id);
}



