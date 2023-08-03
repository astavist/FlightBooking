package com.turkcell.userservice.business.rules;

import com.turkcell.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserBusinessRules {
    private final UserRepository repository;
    public void checkIfUserExists(UUID id){
        if (!repository.existsById(id)) {
            throw new RuntimeException("USER_NOT_EXISTS");
        }

    }
}
