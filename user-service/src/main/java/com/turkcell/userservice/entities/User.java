package com.turkcell.userservice.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String username;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private List<Role> roles;

}
