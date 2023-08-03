package com.turkcell.bookingservice.repository;

import com.turkcell.bookingservice.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
}
