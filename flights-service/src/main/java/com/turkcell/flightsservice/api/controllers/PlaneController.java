package com.turkcell.flightsservice.api.controllers;

import com.turkcell.flightsservice.business.abstracts.PlaneService;
import com.turkcell.flightsservice.business.dto.requests.create.CreatePlaneRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdatePlaneRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreatePlaneResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetPlaneResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllPlanesResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdatePlaneResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/planes")
@AllArgsConstructor
public class PlaneController {
    private final PlaneService service;

    @GetMapping
    public List<GetAllPlanesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetPlaneResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePlaneResponse add(@Valid @RequestBody CreatePlaneRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdatePlaneResponse update(@PathVariable UUID id, @Valid @RequestBody UpdatePlaneRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
