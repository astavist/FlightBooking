package com.turkcell.flightsservice.business.concretes;

import com.turkcell.commonpackage.utils.mapper.ModelMapperService;
import com.turkcell.flightsservice.business.abstracts.AirportService;
import com.turkcell.flightsservice.business.dto.requests.create.CreateAirportRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdateAirportRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreateAirportResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetAirportResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllAirportsResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdateAirportResponse;
import com.turkcell.flightsservice.business.rules.AirportBusinessRules;
import com.turkcell.flightsservice.entities.Airport;
import com.turkcell.flightsservice.repository.AirportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AirportManager implements AirportService {
    private final AirportRepository repository;
    private final ModelMapperService mapper;
    private final AirportBusinessRules rules;

    @Override
    public List<GetAllAirportsResponse> getAll() {
        var airports = repository.findAll();
        var response = airports.stream().map(airport -> mapper.forResponse().map(airport, GetAllAirportsResponse.class)).toList();
        return response;
    }

    @Override
    public GetAirportResponse getById(UUID id) {
        rules.checkIfAirportExist(id);
        var airport = repository.findById(id);
        var response = mapper.forResponse().map(airport, GetAirportResponse.class);
        return response;
    }

    @Override
    public CreateAirportResponse add(CreateAirportRequest request) {
        var airport = mapper.forResponse().map(request, Airport.class);
        repository.save(airport);
        var response = mapper.forResponse().map(airport, CreateAirportResponse.class);
        return response;
    }

    @Override
    public UpdateAirportResponse update(UUID id, UpdateAirportRequest request) {
        rules.checkIfAirportExist(id);
        var airport = mapper.forResponse().map(request, Airport.class);
        airport.setId(id);
        repository.save(airport);
        var response = mapper.forResponse().map(airport, UpdateAirportResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfAirportExist(id);
        repository.deleteById(id);
    }
}
