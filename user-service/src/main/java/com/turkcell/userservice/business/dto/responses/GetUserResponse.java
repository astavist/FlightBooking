package com.turkcell.userservice.business.dto.responses;

import com.turkcell.userservice.entities.enums.Gender;
import com.turkcell.userservice.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private Gender gender;
    private Role role;
}

