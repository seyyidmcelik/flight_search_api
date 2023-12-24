package com.example.flight_search_api.init;

import com.example.flight_search_api.model.Airport;
import com.example.flight_search_api.model.Flight;
import com.example.flight_search_api.repository.AirportRepository;
import com.example.flight_search_api.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    public DataInitializer(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @Override
    public void run(String... args) throws ParseException {
        // Sample Airport data
        Airport airport1 = new Airport();
        airport1.setCity("Istanbul");
        airportRepository.save(airport1);

        Airport airport2 = new Airport();
        airport2.setCity("Ankara");
        airportRepository.save(airport2);

        Airport airport3 = new Airport();
        airport3.setCity("Bursa");
        airportRepository.save(airport3);

        // Sample Flight data
        Flight flight1 = new Flight();
        flight1.setDepartureAirport(airport1.getCity());
        flight1.setArrivalAirport(airport2.getCity());
        flight1.setDepartureDateTime(LocalDateTime.of(2023, 11, 8, 8, 20));
        flight1.setReturnDateTime(LocalDateTime.of(2023, 12, 15, 15, 45));
        flight1.setPrice(300.0);
        flightRepository.save(flight1);

        Flight flight2 = new Flight();
        flight2.setDepartureAirport(airport2.getCity());
        flight2.setArrivalAirport(airport3.getCity());
        flight2.setDepartureDateTime(LocalDateTime.of(2021, 5, 8, 11, 30));
        flight2.setPrice(150.0);
        flightRepository.save(flight2);

        Flight flight3 = new Flight();
        flight3.setDepartureAirport(airport3.getCity());
        flight3.setArrivalAirport(airport1.getCity());
        flight3.setDepartureDateTime(LocalDateTime.of(2022, 3, 1, 10, 10));
        flight3.setPrice(150.0);
        flightRepository.save(flight3);
    }
    
}
