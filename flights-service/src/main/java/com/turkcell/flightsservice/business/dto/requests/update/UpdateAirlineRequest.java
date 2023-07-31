package com.turkcell.flightsservice.business.dto.requests.update;

import com.turkcell.flightsservice.entities.enums.ClassName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class UpdateAirlineRequest {
    @NotBlank
    @Size(min = 2,max = 30)
    private String name;
}

