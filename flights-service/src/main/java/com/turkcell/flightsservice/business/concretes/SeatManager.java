package com.turkcell.flightsservice.business.concretes;

import com.turkcell.commonpackage.utils.dto.ClientResponse;
import com.turkcell.commonpackage.utils.mapper.ModelMapperService;
import com.turkcell.flightsservice.business.abstracts.SeatService;
import com.turkcell.flightsservice.business.dto.requests.create.CreateSeatRequest;
import com.turkcell.flightsservice.business.dto.requests.update.UpdateSeatRequest;
import com.turkcell.flightsservice.business.dto.responses.create.CreateSeatResponse;
import com.turkcell.flightsservice.business.dto.responses.get.GetSeatResponse;
import com.turkcell.flightsservice.business.dto.responses.getall.GetAllSeatsResponse;
import com.turkcell.flightsservice.business.dto.responses.update.UpdateSeatResponse;
import com.turkcell.flightsservice.business.rules.SeatBusinessRules;
import com.turkcell.flightsservice.entities.Seat;
import com.turkcell.flightsservice.entities.enums.SeatStatus;
import com.turkcell.flightsservice.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SeatManager implements SeatService {
    private final SeatRepository repository;
    private final ModelMapperService mapper;
    private final SeatBusinessRules rules;

    @Override
    public List<GetAllSeatsResponse> getAll() {
        var seats = repository.findAll();
        var response = seats.stream().map(seat -> mapper.forResponse().map(seat,GetAllSeatsResponse.class)).toList();
        return response;
    }

    @Override
    public GetSeatResponse getById(UUID id) {
        rules.checkIfSeatExists(id);
        var seat = repository.findById(id).orElseThrow();
        var response = mapper.forResponse().map(seat,GetSeatResponse.class);
        return response;
    }

    @Override
    public CreateSeatResponse add(CreateSeatRequest request) {
        var seat = mapper.forResponse().map(request, Seat.class);
        seat.setId(null);
        repository.save(seat);
        var response = mapper.forResponse().map(seat, CreateSeatResponse.class);
        return response;
    }

    @Override
    public UpdateSeatResponse update(UUID id, UpdateSeatRequest request) {
        rules.checkIfSeatExists(id);
        var seat = mapper.forResponse().map(request, Seat.class);
        seat.setId(id);
        repository.save(seat);

        var response = mapper.forResponse().map(seat, UpdateSeatResponse.class);
        return response;
    }

    @Override
    public ClientResponse checkSeatIsValid(UUID id) {
        ClientResponse response = new ClientResponse();
        Seat seat = mapper.forResponse().map(repository.findById(id),Seat.class);
        if (seat.getStatus()== SeatStatus.AVAILABLE) {
            response.setValid(true);
            response.setMessage("Koltuk doğrulandı:");
        }
        else {
            response.setValid(false);
            response.setMessage("Koltuk doğrulanamadı:");
        }
        return response;
    }

    @Override
    public void changeSeatStatus(UUID id) {
        rules.checkIfSeatExists(id);
        Seat seat = mapper.forResponse().map(repository.findById(id),Seat.class);
        seat.setId(id);
        if (seat.getStatus()==SeatStatus.AVAILABLE){
            seat.setStatus(SeatStatus.BOOKED);
        }
        else {
            seat.setStatus(SeatStatus.AVAILABLE);
        }
        repository.save(seat);
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfSeatExists(id);
        repository.deleteById(id);
    }
}
