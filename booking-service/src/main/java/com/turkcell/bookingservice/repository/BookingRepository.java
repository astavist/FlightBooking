package com.turkcell.bookingservice.repository;

import com.turkcell.bookingservice.entities.Booking;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@ComponentScan
public interface BookingRepository extends JpaRepository<Booking, UUID> {
}
