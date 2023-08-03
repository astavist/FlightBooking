package com.turkcell.bookingservice.business.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookingRequest {
    private String username;
    private String password;
    private UUID flightId;
    private UUID seatId;
}
