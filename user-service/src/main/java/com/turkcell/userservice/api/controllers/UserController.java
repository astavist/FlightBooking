package com.turkcell.userservice.api.controllers;

import com.turkcell.userservice.business.abstracts.UserService;
import com.turkcell.userservice.business.dto.requests.CreateUserRequest;
import com.turkcell.userservice.business.dto.requests.UpdateUserRequest;
import com.turkcell.userservice.business.dto.responses.CreateUserResponse;
import com.turkcell.userservice.business.dto.responses.GetAllUsersResponse;
import com.turkcell.userservice.business.dto.responses.GetUserResponse;
import com.turkcell.userservice.business.dto.responses.UpdateUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/airports")
@AllArgsConstructor
public class UserController {
    private final UserService service;
    @GetMapping
    public List<GetAllUsersResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetUserResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse add(@RequestBody CreateUserRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateUserResponse update(@PathVariable UUID id,@RequestBody UpdateUserRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
