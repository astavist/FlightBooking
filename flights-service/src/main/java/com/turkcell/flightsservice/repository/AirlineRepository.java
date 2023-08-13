package com.turkcell.flightsservice.repository;

import com.turkcell.flightsservice.entities.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AirlineRepository extends JpaRepository<Airline, UUID> {
}

