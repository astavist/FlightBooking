package com.turkcell.flightsservice.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFlightResponse {
    private UUID id;
    private UUID planeId;
    private UUID startAirportId;
    private UUID destinationAirportId;
    private Date startDay;
    private Time startTime;
}
