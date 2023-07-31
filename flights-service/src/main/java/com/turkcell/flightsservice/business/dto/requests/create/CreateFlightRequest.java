package com.turkcell.flightsservice.business.dto.requests.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateFlightRequest {
    @NotNull
    private UUID planeId;
    @NotNull
    private UUID startAirportId;
    @NotNull
    private UUID destinationAirportId;
    private Date startDay;
    private Time startTime;

}
