package com.turkcell.flightsservice.business.concretes;

import com.turkcell.commonpackage.utils.mapper.ModelMapperService;
import com.turkcell.flightsservice.business.abstracts.FlightService;
import com.turkcell.flightsservice.business.dto.requests.create.CreateFlightRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdateFlightRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreateFlightResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetFlightResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllFlightsResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdateFlightResponse;
import com.turkcell.flightsservice.business.rules.FlightBusinessRules;
import com.turkcell.flightsservice.entities.Flight;
import com.turkcell.flightsservice.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FlightManager implements FlightService {
    private final FlightRepository repository;
    private final ModelMapperService mapper;
    private final FlightBusinessRules rules;

    @Override
    public List<GetAllFlightsResponse> getAll() {
        var flights = repository.findAll();
        var response = flights.stream().map(flight -> mapper.forResponse().map(flight, GetAllFlightsResponse.class)).toList();
        return response;
    }

    @Override
    public GetFlightResponse getById(UUID id) {
        rules.checkIfFlightExist(id);
        var flight = repository.findById(id);
        var response = mapper.forResponse().map(flight, GetFlightResponse.class);
        return response;
    }

    @Override
    public CreateFlightResponse add(CreateFlightRequest request) {
        var flight = mapper.forResponse().map(request, Flight.class);
        repository.save(flight);
        var response = mapper.forResponse().map(flight, CreateFlightResponse.class);
        return response;
    }

    @Override
    public UpdateFlightResponse update(UUID id, UpdateFlightRequest request) {
        rules.checkIfFlightExist(id);
        var flight = mapper.forResponse().map(request, Flight.class);
        flight.setId(id);
        repository.save(flight);
        var response = mapper.forResponse().map(flight, UpdateFlightResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfFlightExist(id);
        repository.deleteById(id);
    }
}
