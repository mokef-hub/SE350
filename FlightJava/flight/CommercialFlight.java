package FlightJava.flight;

import FlightJava.airline.Airline;
import FlightJava.airport.Airport;
import FlightJava.exception.NullParameterException;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class CommercialFlight implements Flight {

    private Airline airline;
    private Airport origin;
    private Airport destination;
    private UUID flightNumber;
    private Date departureTime;

    public CommercialFlight(Airline airline, Airport origin, Airport destination) throws NullParameterException {
        setAirline(airline);
        setOrigin(origin);
        setDestination(destination);
        setFlightNumber();
        setDepartureTime();
    }

    private void setFlightNumber() {
        this.flightNumber = UUID.randomUUID();
    }

    private void setDepartureTime() {
        this.departureTime = new Date(2022, 05, 05, 13, 30);
    }

    public String getAirline() {
        return airline.toString();
    }

    private void setAirline(Airline airline) throws NullParameterException {
        if (airline == null) {
            throw new NullParameterException(("Airline cannot be null"));
        }
        this.airline = airline;
    }

    public String getOrigin() {
        return origin.toString();
    }

    private void setOrigin(Airport origin) throws NullParameterException {
        if (origin == null) {
            throw new NullParameterException("Origin cannot be null.");
        }
        this.origin = origin;
    }

    public String getDestination() {
        return destination.toString();
    }

    private void setDestination(Airport destination) throws NullParameterException {
        if (destination == null) {
            throw new NullParameterException("Destination cannot be null.");
        }
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber.toString();
    }

    public String getDepartureTime() {
        return departureTime.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommercialFlight commercialFlight = (CommercialFlight) o;
        return Objects.equals(airline, commercialFlight.airline) &&
                Objects.equals(origin, commercialFlight.origin) &&
                Objects.equals(destination, commercialFlight.destination) &&
                Objects.equals(flightNumber, commercialFlight.flightNumber) &&
                Objects.equals(departureTime, commercialFlight.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airline, origin, destination, flightNumber, departureTime);
    }

    @Override
    public String toString() {
        return String.format("Flight{airline=%s, origin=%s, destination=%s, flightNumber=%s, departureTime=%s}", getAirline(), getOrigin(), getDestination(), getFlightNumber(), getDepartureTime());
    }
}
