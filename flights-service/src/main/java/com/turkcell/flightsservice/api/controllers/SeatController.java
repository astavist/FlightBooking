package com.turkcell.flightsservice.api.controllers;

import com.turkcell.flightsservice.business.abstracts.SeatService;
import com.turkcell.flightsservice.business.dto.requests.create.CreateSeatRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdateSeatRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreateSeatResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetSeatResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllSeatsResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdateSeatResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/seats")
@AllArgsConstructor
public class SeatController {
    private final SeatService service;

    @GetMapping
    public List<GetAllSeatsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetSeatResponse getById(@PathVariable UUID id) {return service.getById(id);
    }

    @PostMapping
    public CreateSeatResponse add(@Valid @RequestBody CreateSeatRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateSeatResponse update(@PathVariable UUID id,@Valid @RequestBody UpdateSeatRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    void delete(UUID id) {
        service.delete(id);
    }
}
