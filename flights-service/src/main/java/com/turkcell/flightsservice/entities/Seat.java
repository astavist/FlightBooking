package com.turkcell.flightsservice.entities;

import com.turkcell.flightsservice.entities.enums.ClassName;
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
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private ClassName className;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

}
