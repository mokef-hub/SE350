package FlightJava.flight;

import FlightJava.airline.Airline;
import FlightJava.airport.Airport;
import FlightJava.exception.BadParameterException;
import FlightJava.exception.NullParameterException;

import java.util.Date;
import java.util.UUID;

public class PassengerFlight implements Flight {

    private Airline airline;
    private Airport origin;
    private Airport destination;
    private UUID flightNumber;
    private Date departureTime;
    private int passengerCapacity = 0;

    public PassengerFlight(
            Airline airline,
            Airport origin,
            Airport destination,
            int passengerCapacity
    ) throws NullParameterException, BadParameterException {
        setAirline(airline);
        setOrigin(origin);
        setDestination(destination);
        setPassengerCapacity(passengerCapacity);
        setFlightNumber();
        setDepartureTime();
    }

    private void setFlightNumber() {
        this.flightNumber = UUID.randomUUID();
    }

    private void setDepartureTime() {
        this.departureTime = new Date(2022, 05, 05, 13, 30);
    }

    public Airline getAirline() {
        return airline;
    }

    private void setAirline(Airline airline) throws NullParameterException {
        if (airline == null) {
            throw new NullParameterException(("Airline cannot be null"));
        }
        this.airline = airline;
    }

    public Airport getOrigin() {
        return origin;
    }

    private void setOrigin(Airport origin) throws NullParameterException {
        if (origin == null) {
            throw new NullParameterException("Origin cannot be null.");
        }
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    private void setDestination(Airport destination) throws NullParameterException {
        if (destination == null) {
            throw new NullParameterException("Destination cannot be null.");
        }
        this.destination = destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    @Override
    public String getFlightNumber() {
        return flightNumber.toString();
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) throws BadParameterException {
        if (passengerCapacity < 0) {
            throw new BadParameterException("Passenger capacity cannot be negative.");
        }

        this.passengerCapacity = passengerCapacity;
    }


    @Override
    public String toString() {
        return String.format("Flight{airline=%s, origin=%s, destination=%s, flightNumber=%s, departureTime=%s, passengerCapacity=%d}", getAirline(), getOrigin(), getDestination(), getFlightNumber(), getDepartureTime(), getPassengerCapacity());
    }

}
