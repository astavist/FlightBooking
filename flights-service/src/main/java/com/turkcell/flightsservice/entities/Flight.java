package com.turkcell.flightsservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;
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
    private Date startDay;
    private Time startTime;


    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;

    @ManyToMany
    @JoinColumn(name = "airline_id")
    private List<Airline> airlines;
}
