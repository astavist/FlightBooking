package com.turkcell.flightsservice.business.dto.requests.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlaneRequest {
    @NotNull
    private UUID airlineId;
    @NotBlank
    private String name;

}
