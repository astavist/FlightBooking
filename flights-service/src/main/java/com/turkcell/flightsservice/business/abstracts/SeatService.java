package com.turkcell.flightsservice.business.abstracts;

import com.turkcell.flightsservice.business.dto.requests.create.CreateSeatRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdateSeatRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreateSeatResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetSeatResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllSeatsResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdateSeatResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface SeatService {
    List<GetAllSeatsResponse> getAll();

    GetSeatResponse getById(UUID id);

    CreateSeatResponse add(CreateSeatRequest request);

    UpdateSeatResponse update(UUID id, UpdateSeatRequest request);

    void delete(UUID id);
}
