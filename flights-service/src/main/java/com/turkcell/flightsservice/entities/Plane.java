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
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL)
    private List<Seat> seats;

    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL)
    private List<Flight> flights;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;
}
