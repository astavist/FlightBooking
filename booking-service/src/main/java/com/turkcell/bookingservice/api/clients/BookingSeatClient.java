package com.turkcell.bookingservice.api.clients;

import com.turkcell.commonpackage.utils.dto.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "flight-seat-service")
public interface BookingSeatClient {
    @GetMapping(value = "/api/seats/check-seat/{id}")
    ClientResponse checkSeatIsValid(@PathVariable UUID id);
}
