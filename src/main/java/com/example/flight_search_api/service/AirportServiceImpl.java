package com.example.flight_search_api.service;

import com.example.flight_search_api.model.Airport;
import com.example.flight_search_api.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    @Override
    public Airport createOrUpdateAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}
