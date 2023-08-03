package com.turkcell.userservice.business.abstracts;

import com.turkcell.commonpackage.utils.dto.ClientResponse;
import com.turkcell.userservice.business.dto.requests.CreateUserRequest;
import com.turkcell.userservice.business.dto.requests.UpdateUserRequest;
import com.turkcell.userservice.business.dto.responses.CreateUserResponse;
import com.turkcell.userservice.business.dto.responses.GetAllUsersResponse;
import com.turkcell.userservice.business.dto.responses.GetUserResponse;
import com.turkcell.userservice.business.dto.responses.UpdateUserResponse;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<GetAllUsersResponse> getAll();

    GetUserResponse getById(UUID id);

    CreateUserResponse add(CreateUserRequest request);

    UpdateUserResponse update(UUID id, UpdateUserRequest request);
    ClientResponse checkUserIsValid(@PathVariable String username,@PathVariable String password);

    void delete(UUID id);
}
