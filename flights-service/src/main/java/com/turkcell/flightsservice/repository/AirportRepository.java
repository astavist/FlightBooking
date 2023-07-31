package com.turkcell.flightsservice.repository;

import com.turkcell.flightsservice.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AirportRepository extends JpaRepository<Airport, UUID> {
}

