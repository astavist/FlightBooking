package com.turkcell.userservice.business.dto.requests;

import com.turkcell.userservice.entities.enums.Gender;
import com.turkcell.userservice.entities.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private String username;
    private String password;
    private String email;
    private Gender gender;
    private Role role;
}
