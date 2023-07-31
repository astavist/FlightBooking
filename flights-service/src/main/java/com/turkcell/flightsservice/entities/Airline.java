package com.turkcell.flightsservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @OneToOne(mappedBy = "airline", cascade = CascadeType.ALL)
    private Plane plane;

    @ManyToMany(mappedBy = "airlines", cascade = CascadeType.ALL)
    private List<Flight> flights;


}
