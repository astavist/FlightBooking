package com.turkcell.bookingservice.business.rules;

import com.turkcell.bookingservice.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BookingBusinessRules {
    private final BookingRepository repository;

    public void checkIfBookingExists(UUID id){
        if (!repository.existsById(id)){
            throw new RuntimeException("BOOKING_NOT_EXISTS");
        }
    }
}
