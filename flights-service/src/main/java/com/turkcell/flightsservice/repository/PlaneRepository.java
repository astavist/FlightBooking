package com.turkcell.flightsservice.repository;

import com.turkcell.flightsservice.entities.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaneRepository extends JpaRepository<Plane, UUID> {
}
