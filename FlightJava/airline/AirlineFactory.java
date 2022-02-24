package FlightJava.airline;

import FlightJava.exception.BadParameterException;
import FlightJava.exception.NullParameterException;

import java.util.HashMap;
import java.util.Map;

public class AirlineFactory {

    private static AirlineFactory instance;
    private final Map<String, Airline> airlineMap = new HashMap<>();

    private AirlineFactory() {
    }

    public static AirlineFactory getInstance() {
        if (instance == null) {
            instance = new AirlineFactory();
        }

        return instance;
    }

    public Airline getAirline(String name) throws BadParameterException, NullParameterException {
        if (!airlineMap.containsKey(name)) {
            airlineMap.put(name, new Airline(name));
        }

        return airlineMap.get(name);
    }

}
