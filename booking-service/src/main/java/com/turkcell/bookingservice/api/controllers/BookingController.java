package com.turkcell.bookingservice.api.controllers;

import com.turkcell.bookingservice.business.abstracts.BookingService;
import com.turkcell.bookingservice.business.dto.requests.CreateBookingRequest;
import com.turkcell.bookingservice.business.dto.requests.UpdateBookingRequest;
import com.turkcell.bookingservice.business.dto.responses.CreateBookingResponse;
import com.turkcell.bookingservice.business.dto.responses.GetAllBookingsResponse;
import com.turkcell.bookingservice.business.dto.responses.GetBookingResponse;
import com.turkcell.bookingservice.business.dto.responses.UpdateBookingResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bookings")
@AllArgsConstructor
public class BookingController {
    private final BookingService service;
    @GetMapping
    public List<GetAllBookingsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetBookingResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBookingResponse add(@RequestBody CreateBookingRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateBookingResponse update(@PathVariable UUID id, @RequestBody UpdateBookingRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
