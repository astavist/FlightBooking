package com.turkcell.flightsservice.api.controllers;

import com.turkcell.flightsservice.business.abstracts.AirlineService;
import com.turkcell.flightsservice.business.dto.requests.create.CreateAirlineRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdateAirlineRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreateAirlineResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetAirlineResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllAirlinesResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdateAirlineResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/airlines")
@AllArgsConstructor
public class AirlineController {
    private final AirlineService service;

    @GetMapping
    public List<GetAllAirlinesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetAirlineResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAirlineResponse add(@Valid @RequestBody CreateAirlineRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateAirlineResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateAirlineRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
