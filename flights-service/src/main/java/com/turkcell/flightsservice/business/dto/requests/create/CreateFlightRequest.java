package com.turkcell.flightsservice.business.dto.requests.create;

import com.turkcell.commonpackage.utils.constants.DateRegex;
import com.turkcell.commonpackage.utils.constants.TimeRegex;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.ModelAttribute;

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

    @Pattern(regexp = DateRegex.dateRegex)
    private String startDay;

    @Pattern(regexp = TimeRegex.timeRegex)
    private String startTimeHHMM;

}
