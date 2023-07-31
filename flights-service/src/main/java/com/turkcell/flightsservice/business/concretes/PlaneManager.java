package com.turkcell.flightsservice.business.concretes;

import com.turkcell.commonpackage.utils.mapper.ModelMapperService;
import com.turkcell.flightsservice.business.abstracts.PlaneService;
import com.turkcell.flightsservice.business.dto.requests.create.CreatePlaneRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdatePlaneRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreatePlaneResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetPlaneResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllPlanesResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdatePlaneResponse;
import com.turkcell.flightsservice.business.rules.PlaneBusinessRules;
import com.turkcell.flightsservice.entities.Plane;
import com.turkcell.flightsservice.repository.PlaneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlaneManager implements PlaneService {
    private final PlaneRepository repository;
    private final ModelMapperService mapper;
    private final PlaneBusinessRules rules;
    @Override
    public List<GetAllPlanesResponse> getAll() {
        var planes = repository.findAll();
        var response = planes.stream().map(plane -> mapper.forResponse().map(plane,GetAllPlanesResponse.class)).toList();
        return response;
    }

    @Override
    public GetPlaneResponse getById(UUID id) {
        rules.checkIfPlaneExist(id);
        var plane = repository.findById(id);
        var response = mapper.forResponse().map(plane,GetPlaneResponse.class);
        return response;
    }

    @Override
    public CreatePlaneResponse add(CreatePlaneRequest request) {
        var plane = mapper.forResponse().map(request, Plane.class);
        repository.save(plane);
        var response = mapper.forResponse().map(plane,CreatePlaneResponse.class);
        return response;
    }

    @Override
    public UpdatePlaneResponse update(UUID id, UpdatePlaneRequest request) {
        rules.checkIfPlaneExist(id);
        var plane = mapper.forResponse().map(request, Plane.class);
        plane.setId(id);
        repository.save(plane);
        var response = mapper.forResponse().map(plane,UpdatePlaneResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfPlaneExist(id);
        repository.deleteById(id);
    }
}
