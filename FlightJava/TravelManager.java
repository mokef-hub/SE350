package FlightJava;

import FlightJava.exception.BadParameterException;
import FlightJava.exception.NullParameterException;
import FlightJava.flight.Flight;

import java.util.Optional;

public class TravelManager {

    public static void main(String[] args) throws Exception {
        try {
            FlightManager manager = FlightManager.getInstance();
            String flightNumber = manager.createFlight("passengerFlight", "Spirit", "ORD", "DFW", 0);
            Optional<Flight> flight = manager.getFlightByFlightNumber(flightNumber);

            System.out.println(flight.get());
        } catch (NullParameterException | BadParameterException ex) {
            ex.printStackTrace();
        }
    }

}
