package com.example.flight_search_api.service;

import com.example.flight_search_api.model.Flight;
import com.example.flight_search_api.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    @Override
    public Flight createOrUpdateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public List<Flight> getFlightsByCriteria(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime, LocalDateTime returnDateTime) {
        if (departureDateTime != null && returnDateTime != null) {
            return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateTimeBetween(
                    departureAirport, arrivalAirport, departureDateTime, returnDateTime);
        } else if (departureDateTime != null) {
            return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateTime(
                    departureAirport, arrivalAirport, departureDateTime);
        } else if (returnDateTime != null) {
            return flightRepository.findByDepartureAirportAndArrivalAirportAndReturnDateTime(
                    departureAirport, arrivalAirport, returnDateTime);
        } else {
            return flightRepository.findByDepartureAirportAndArrivalAirport(departureAirport, arrivalAirport);
        }
    }

}
