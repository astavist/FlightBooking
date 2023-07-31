package com.turkcell.flightsservice.business.abstracts;

import com.turkcell.flightsservice.business.dto.requests.create.CreatePlaneRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdatePlaneRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreatePlaneResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetPlaneResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllPlanesResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdatePlaneResponse;

import java.util.List;
import java.util.UUID;

public interface
PlaneService {
    List<GetAllPlanesResponse> getAll();

    GetPlaneResponse getById(UUID id);

    CreatePlaneResponse add(CreatePlaneRequest request);

    UpdatePlaneResponse update(UUID id, UpdatePlaneRequest request);

    void delete(UUID id);
}
