package com.example.flight_search_api.service;

import com.example.flight_search_api.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<Flight> getAllFlights();
    Flight getFlightById(Long id);
    Flight createOrUpdateFlight(Flight flight);
    void deleteFlight(Long id);
    List<Flight> getFlightsByCriteria(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime, LocalDateTime returnDateTime);
}
