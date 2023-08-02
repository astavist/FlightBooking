package com.turkcell.flightsservice.business.dto.requests.update;

import com.turkcell.commonpackage.utils.constants.DateRegex;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFlightRequest {
    @NotNull
    private UUID planeId;
    @NotNull
    private UUID startAirportId;
    @NotNull
    private UUID destinationAirportId;

    @Pattern(regexp = DateRegex.dateRegex)
    private Date startDateTime;
}
