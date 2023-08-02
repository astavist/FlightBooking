package com.turkcell.flightsservice.business.rules;

import com.turkcell.flightsservice.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FlightBusinessRules {
    private final FlightRepository repository;
    public void checkIfFlightExist(UUID id){
        if (!repository.existsById(id)) {
            throw new RuntimeException("FLIGHT_NOT_EXISTS");
        }
    }

    public Date dateFormatter(String date) {
        Date formattedDate = null;
        try {
            formattedDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(date);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return formattedDate;
    }
}
