package com.turkcell.bookingservice.business.abstracts;

import com.turkcell.bookingservice.business.dto.requests.CreateBookingRequest;
import com.turkcell.bookingservice.business.dto.requests.UpdateBookingRequest;
import com.turkcell.bookingservice.business.dto.responses.CreateBookingResponse;
import com.turkcell.bookingservice.business.dto.responses.GetAllBookingsResponse;
import com.turkcell.bookingservice.business.dto.responses.GetBookingResponse;
import com.turkcell.bookingservice.business.dto.responses.UpdateBookingResponse;

import java.util.List;
import java.util.UUID;

public interface BookingService {
    List<GetAllBookingsResponse> getAll();

    GetBookingResponse getById(UUID id);

    CreateBookingResponse add(CreateBookingRequest request);

    UpdateBookingResponse update(UUID id, UpdateBookingRequest request);

    void delete(UUID id);
}
