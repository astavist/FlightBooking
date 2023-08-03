package com.turkcell.bookingservice.business.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBookingsResponse {
    private UUID id;
    private String username;
    private String password;
    private UUID flightId;
    private UUID seatId;
    private boolean isPaid;
}
