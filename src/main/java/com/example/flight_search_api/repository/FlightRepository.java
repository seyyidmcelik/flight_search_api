package com.example.flight_search_api.repository;

import com.example.flight_search_api.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateTimeBetween(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime, LocalDateTime departureDateTime2);

    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateTime(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime);

    List<Flight> findByDepartureAirportAndArrivalAirportAndReturnDateTime(String departureAirport, String arrivalAirport, LocalDateTime returnDateTime);

    List<Flight> findByDepartureAirportAndArrivalAirport(String departureAirport, String arrivalAirport);
}
