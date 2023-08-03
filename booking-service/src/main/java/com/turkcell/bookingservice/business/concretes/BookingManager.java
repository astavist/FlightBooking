package com.turkcell.bookingservice.business.concretes;

import com.turkcell.bookingservice.api.clients.BookingFlightClient;
import com.turkcell.bookingservice.api.clients.BookingSeatClient;
import com.turkcell.bookingservice.api.clients.BookingUserClient;
import com.turkcell.bookingservice.business.abstracts.BookingService;
import com.turkcell.bookingservice.business.dto.requests.CreateBookingRequest;
import com.turkcell.bookingservice.business.dto.requests.UpdateBookingRequest;
import com.turkcell.bookingservice.business.dto.responses.CreateBookingResponse;
import com.turkcell.bookingservice.business.dto.responses.GetAllBookingsResponse;
import com.turkcell.bookingservice.business.dto.responses.GetBookingResponse;
import com.turkcell.bookingservice.business.dto.responses.UpdateBookingResponse;
import com.turkcell.bookingservice.entities.Booking;
import com.turkcell.bookingservice.repository.BookingRepository;
import com.turkcell.commonpackage.utils.mapper.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookingManager implements BookingService {
    private final BookingRepository repository;
    private final ModelMapperService mapper;
    private final BookingUserClient userClient;
    private final BookingFlightClient flightClient;
    private final BookingSeatClient seatClient;

    @Override
    public List<GetAllBookingsResponse> getAll() {
        List<Booking> bookings = repository.findAll();
        List<GetAllBookingsResponse> response = bookings
                .stream()
                .map(booking -> mapper
                        .forResponse()
                        .map(booking, GetAllBookingsResponse.class)).toList();
        return response;
    }

    @Override
    public GetBookingResponse getById(UUID id) {
        Booking booking = repository.findById(id).orElseThrow();
        GetBookingResponse response = mapper.forResponse().map(booking,GetBookingResponse.class);
        return response;
    }

    @Override
    public CreateBookingResponse add(CreateBookingRequest request) {
        userClient.checkUserIsValid(request.getUsername(),request.getPassword());
        flightClient.checkFlightIsValid(request.getFlightId());
        seatClient.checkSeatIsValid(request.getSeatId());
        Booking booking = mapper.forResponse().map(request,Booking.class);
        booking.setId(null);
        repository.save(booking);
        CreateBookingResponse response = mapper.forResponse().map(booking,CreateBookingResponse.class);
        return response;
    }

    @Override
    public UpdateBookingResponse update(UUID id, UpdateBookingRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
