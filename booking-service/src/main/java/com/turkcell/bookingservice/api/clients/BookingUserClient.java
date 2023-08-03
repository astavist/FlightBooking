package com.turkcell.bookingservice.api.clients;

import com.turkcell.commonpackage.utils.dto.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface BookingUserClient {
    @GetMapping(value = "/api/users/check-user/{id}")
    ClientResponse checkUserIsValid(@PathVariable String username,@PathVariable String password);
}
