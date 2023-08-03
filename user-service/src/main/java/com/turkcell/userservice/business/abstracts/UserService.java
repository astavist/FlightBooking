package com.turkcell.userservice.business.abstracts;

import com.turkcell.userservice.business.dto.requests.CreateUserRequest;
import com.turkcell.userservice.business.dto.requests.UpdateUserRequest;
import com.turkcell.userservice.business.dto.responses.CreateUserResponse;
import com.turkcell.userservice.business.dto.responses.GetAllUsersResponse;
import com.turkcell.userservice.business.dto.responses.GetUserResponse;
import com.turkcell.userservice.business.dto.responses.UpdateUserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<GetAllUsersResponse> getAll();

    GetUserResponse getById(UUID id);

    CreateUserResponse add(CreateUserRequest request);

    UpdateUserResponse update(UUID id, UpdateUserRequest request);

    void delete(UUID id);
}
