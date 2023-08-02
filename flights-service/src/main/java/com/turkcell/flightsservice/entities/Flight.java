package com.turkcell.flightsservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID startAirportId;
    private UUID destinationAirportId;
    private Date startDateTime;


    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Seat> seats;
}
