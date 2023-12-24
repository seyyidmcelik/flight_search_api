package com.example.flight_search_api.service;

import com.example.flight_search_api.model.Airport;

import java.util.List;

public interface AirportService {
    List<Airport> getAllAirports();
    Airport getAirportById(Long id);
    Airport createOrUpdateAirport(Airport airport);
    void deleteAirport(Long id);
}

