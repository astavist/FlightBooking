package com.turkcell.flightsservice.business.kafka.consumer;

import com.turkcell.commonpackage.events.booking.SeatBookingCreatedEvent;
import com.turkcell.commonpackage.events.booking.SeatBookingDeletedEvent;
import com.turkcell.flightsservice.business.abstracts.SeatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingConsumer {
    private SeatService seatService;

    @KafkaListener(
            topics = "seat-book-created",
            groupId = "flight-seat-book-create"
    )
    public void consume(SeatBookingCreatedEvent event) {
        seatService.changeSeatStatus(event.getSeatId());
        log.info("Seat booking creating event consumed {}",event);
    }

    @KafkaListener(
            topics = "seat-book-deleted",
            groupId = "flight-seat-book-delete"
    )
    public void consume(SeatBookingDeletedEvent event) {
        seatService.changeSeatStatus(event.getSeatId());
        log.info("Seat booking deleting event consumed {}",event);
    }

}
