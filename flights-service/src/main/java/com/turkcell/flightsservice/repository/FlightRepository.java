package com.turkcell.flightsservice.repository;

import com.turkcell.flightsservice.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {
}
