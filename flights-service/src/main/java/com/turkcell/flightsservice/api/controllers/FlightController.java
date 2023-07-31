package com.turkcell.flightsservice.api.controllers;

import com.turkcell.flightsservice.business.abstracts.FlightService;
import com.turkcell.flightsservice.business.dto.requests.create.CreateFlightRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdateFlightRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreateFlightResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetFlightResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllFlightsResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdateFlightResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/flights")
@AllArgsConstructor
public class FlightController {
    private final FlightService service;

    @GetMapping
    public List<GetAllFlightsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetFlightResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateFlightResponse add(@Valid @RequestBody CreateFlightRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateFlightResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateFlightRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
