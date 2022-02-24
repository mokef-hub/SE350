package FlightJava.airport;

import FlightJava.exception.BadParameterException;
import FlightJava.exception.NullParameterException;

import java.util.HashMap;
import java.util.Map;

public class AirportFactory {

    private static AirportFactory instance;
    private final Map<String, Airport> airportCache = new HashMap<>();

    private AirportFactory() {
    }

    public static AirportFactory getInstance() {
        if (instance == null) {
            instance = new AirportFactory();
        }

        return instance;
    }

    public Airport getAirport(String name) throws BadParameterException, NullParameterException {
        if (!airportCache.containsKey(name)) {
            airportCache.put(name, new Airport(name));
        }
        return airportCache.get(name);
    }

}
