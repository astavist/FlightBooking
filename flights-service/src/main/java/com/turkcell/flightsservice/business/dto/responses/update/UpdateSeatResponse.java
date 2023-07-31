package com.turkcell.flightsservice.business.dto.responses.update;

import com.turkcell.flightsservice.entities.enums.ClassName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSeatResponse {
    private UUID id;
    private ClassName className;
    private Boolean status;
    private UUID planeId;
}
