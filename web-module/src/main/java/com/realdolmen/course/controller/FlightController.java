package com.realdolmen.course.controller;

import com.realdolmen.ex.domain.DomesticFlight;
import com.realdolmen.ex.domain.Flight;
import com.realdolmen.ex.persistence.FlightRepository;
import com.realdolmen.ex.persistence.TicketRepository;
import sun.security.krb5.internal.Ticket;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
@RequestScoped
public class FlightController
{
    @Inject
    private FlightRepository flightRepository;
    private Flight flight;
    private Long flightId;

    public String showFlightDetails()
    {
        flight = new DomesticFlight();
        flight.setNumber("00000000000000000");
        flightRepository.create(flight);
        flight = flightRepository.findById(Flight.class, flightId);
        return "flight";
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
