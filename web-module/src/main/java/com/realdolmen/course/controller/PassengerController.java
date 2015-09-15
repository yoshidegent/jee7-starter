package com.realdolmen.course.controller;

import com.realdolmen.ex.domain.Passenger;
import com.realdolmen.ex.ejb.PassengerEJB;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class PassengerController
{
    @Inject
    private PassengerEJB passengerEJB;

    private Passenger passenger = new Passenger();
    private List<Passenger> passengerList = new ArrayList<>();

    public String doCreatePassenger()
    {
        passenger = passengerEJB.createPassenger(passenger);
        passengerList = passengerEJB.findPassengers();
        return "allpassengers";
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
