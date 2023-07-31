package com.turkcell.flightsservice.business.dto.requests.create;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAirlineRequest {
    @NotBlank
    @Size(min = 2,max = 30)
    private String name;
}

