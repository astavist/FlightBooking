package com.turkcell.flightsservice.business.concretes;

import com.turkcell.commonpackage.utils.mapper.ModelMapperService;
import com.turkcell.flightsservice.business.abstracts.AirlineService;
import com.turkcell.flightsservice.business.dto.requests.create.CreateAirlineRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdateAirlineRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreateAirlineResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetAirlineResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllAirlinesResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdateAirlineResponse;
import com.turkcell.flightsservice.business.rules.AirlineBusinessRules;
import com.turkcell.flightsservice.entities.Airline;
import com.turkcell.flightsservice.repository.AirlineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AirlineManager implements AirlineService {

    private final AirlineRepository repository;
    private final ModelMapperService mapper;
    private final AirlineBusinessRules rules;

    @Override
    public List<GetAllAirlinesResponse> getAll() {
        var airlines = repository.findAll();
        var response = airlines.stream().map(airline -> mapper.forResponse().map(airline, GetAllAirlinesResponse.class)).toList();
        return response;
    }

    @Override
    public GetAirlineResponse getById(UUID id) {
        rules.checkIfAirlineExist(id);
        var airline = repository.findById(id);
        var response = mapper.forResponse().map(airline, GetAirlineResponse.class);
        return response;
    }

    @Override
    public CreateAirlineResponse add(CreateAirlineRequest request) {
        var airline = mapper.forResponse().map(request, Airline.class);
        repository.save(airline);
        var response = mapper.forResponse().map(airline, CreateAirlineResponse.class);
        return response;
    }

    @Override
    public UpdateAirlineResponse update(UUID id, UpdateAirlineRequest request) {
        rules.checkIfAirlineExist(id);
        var airline = mapper.forResponse().map(request, Airline.class);
        airline.setId(id);
        repository.save(airline);
        var response = mapper.forResponse().map(airline, UpdateAirlineResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfAirlineExist(id);
        repository.deleteById(id);
    }
}
