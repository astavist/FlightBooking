package com.turkcell.flightsservice.api.controllers;

import com.turkcell.flightsservice.business.abstracts.AirportService;
import com.turkcell.flightsservice.business.dto.requests.create.CreateAirportRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdateAirportRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreateAirportResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetAirportResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllAirportsResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdateAirportResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/airports")
@AllArgsConstructor
public class AirportController {
    private final AirportService service;

    @GetMapping
    public List<GetAllAirportsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetAirportResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAirportResponse add(@Valid @RequestBody CreateAirportRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateAirportResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateAirportRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
