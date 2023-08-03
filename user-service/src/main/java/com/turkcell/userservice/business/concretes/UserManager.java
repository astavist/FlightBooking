package com.turkcell.userservice.business.concretes;

import com.turkcell.commonpackage.utils.mapper.ModelMapperService;
import com.turkcell.userservice.business.abstracts.UserService;
import com.turkcell.userservice.business.dto.requests.CreateUserRequest;
import com.turkcell.userservice.business.dto.requests.UpdateUserRequest;
import com.turkcell.userservice.business.dto.responses.CreateUserResponse;
import com.turkcell.userservice.business.dto.responses.GetAllUsersResponse;
import com.turkcell.userservice.business.dto.responses.GetUserResponse;
import com.turkcell.userservice.business.dto.responses.UpdateUserResponse;
import com.turkcell.userservice.business.rules.UserBusinessRules;
import com.turkcell.userservice.entities.User;
import com.turkcell.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final ModelMapperService mapper;
    private final UserRepository repository;
    private final UserBusinessRules rules;
    
    @Override
    public List<GetAllUsersResponse> getAll() {
        var users = repository.findAll();
        var response = users.stream().map(user -> mapper.forResponse().map(user,GetAllUsersResponse.class)).toList();
        return response;
    }

    @Override
    public GetUserResponse getById(UUID id) {
        rules.checkIfUserExists(id);
        var user = repository.findById(id).orElseThrow();
        var response = mapper.forResponse().map(user,GetUserResponse.class);
        return response;
    }

    @Override
    public CreateUserResponse add(CreateUserRequest request) {
        var user = mapper.forResponse().map(request, User.class);
        user.setId(null);
        repository.save(user);
        var response = mapper.forResponse().map(user, CreateUserResponse.class);
        return response;
    }

    @Override
    public UpdateUserResponse update(UUID id, UpdateUserRequest request) {
        rules.checkIfUserExists(id);
        var user = mapper.forResponse().map(request, User.class);
        user.setId(id);
        repository.save(user);

        var response = mapper.forResponse().map(user, UpdateUserResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfUserExists(id);
        repository.deleteById(id);
    }
}
