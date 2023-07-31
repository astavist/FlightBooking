package com.turkcell.flightsservice.business.dto.responses.getall;

import com.turkcell.flightsservice.entities.enums.ClassName;
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
public class GetAllAirlinesResponse {
    private UUID id;
    private String name;
}

