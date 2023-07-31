package com.turkcell.flightsservice.repository;

import com.turkcell.flightsservice.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {
}
