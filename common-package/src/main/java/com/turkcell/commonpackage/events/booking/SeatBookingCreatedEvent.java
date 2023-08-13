package com.turkcell.commonpackage.events.booking;

import com.turkcell.commonpackage.events.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatBookingCreatedEvent implements Event {
    private UUID seatId;
}
