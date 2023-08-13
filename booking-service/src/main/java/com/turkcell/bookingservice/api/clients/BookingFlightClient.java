package com.turkcell.bookingservice.api.clients;

import com.turkcell.commonpackage.utils.dto.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "flight-booking-service")
public interface BookingFlightClient {
    @GetMapping(value = "/api/flights/check-flight/{id}")
    ClientResponse checkFlightIsValid(@PathVariable UUID id);
}
