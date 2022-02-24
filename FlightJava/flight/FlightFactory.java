package FlightJava.flight;

import FlightJava.airline.Airline;
import FlightJava.airport.Airport;
import FlightJava.exception.BadParameterException;
import FlightJava.exception.NullParameterException;

public class FlightFactory {

    private FlightFactory() {
    }

    public static Flight createFlight(String type, Airline airline, Airport origin, Airport destination, int capacity) {
        if (type.equals("commercialFlight")) {
            try {
                return new CommercialFlight(airline, origin, destination);
            } catch (NullParameterException e) {
                return null;
            }
        } else if (type.equals("passengerFlight")) {
            try {
                return new PassengerFlight(airline, origin, destination, capacity);
            } catch (NullParameterException | BadParameterException e) {
                return null;
            }
        } else return null;
    }
}
