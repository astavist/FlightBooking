package com.turkcell.flightsservice.business.dto.responses.getall;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPlanesResponse {
    private UUID id;
    private String name;
    private UUID airlineId;
}
