package FlightJava;

import FlightJava.airline.AirlineFactory;
import FlightJava.airport.AirportFactory;
import FlightJava.exception.BadParameterException;
import FlightJava.exception.NullParameterException;
import FlightJava.flight.Flight;
import FlightJava.flight.FlightFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class FlightManager {

    private static FlightManager ourInstance;
    private final List<Flight> flights;

    private final AirlineFactory airlineFactory = AirlineFactory.getInstance();
    private final AirportFactory airportFactory = AirportFactory.getInstance();

    private FlightManager() {
        flights = new ArrayList<Flight>();
    }

    public static FlightManager getInstance() throws Exception {
        if (ourInstance == null)
            ourInstance = new FlightManager();

        return ourInstance;
    }

    public String createFlight(String type, String airline, String origin, String destination, int capacity) throws BadParameterException, NullParameterException {
        Flight flight = FlightFactory.createFlight(
                type,
                airlineFactory.getAirline(airline),
                airportFactory.getAirport(origin),
                airportFactory.getAirport(destination),
                capacity
        );

        if (flight == null)
            throw new NullParameterException("Flight is null");

        flights.add(flight);
        return flight.getFlightNumber();
    }

    public Optional<Flight> getFlightByFlightNumber(String flightNumber) {
        return flights.stream()
                .filter(flt -> flt.getFlightNumber().equals(flightNumber))
                .findFirst();
    }
}
