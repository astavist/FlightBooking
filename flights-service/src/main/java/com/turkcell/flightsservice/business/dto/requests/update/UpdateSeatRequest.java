package com.turkcell.flightsservice.business.dto.requests.update;

import com.turkcell.flightsservice.entities.enums.ClassName;
import com.turkcell.flightsservice.entities.enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSeatRequest {
    private ClassName className;
    private SeatStatus status;
    private UUID planeId;
}
