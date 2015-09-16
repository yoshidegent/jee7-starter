package com.realdolmen.course.controller;

import com.realdolmen.ex.ejb.PassengerEJB;
import com.realdolmen.ex.persistence.TicketRepository;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class PassengerConversationController implements Serializable{

    @Inject
    private PassengerEJB passengerEJB;
    @Inject
    private TicketRepository ticketRepository;

    @Inject
    private Conversation conversation;
    @Inject
    private Passenger passenger;

    private List<com.realdolmen.ex.domain.Passenger> passengerList = new ArrayList<>();

    public String passengerInfoEntry()
    {
        conversation.begin();
        return navigateToTicketPage();
    }

    private String navigateToTicketPage()
    {
        return "createticket";
    }

    public String navigateToConfirmationPage() {
        return "confirmpassenger";
    }

    public String navigateToAllPassengersPage()
    {
        com.realdolmen.ex.domain.Passenger passengerDB = new com.realdolmen.ex.domain.Passenger();
        passengerDB.setSsn(passenger.getSsn());
        passengerDB.setFirstName(passenger.getFirstName());
        passengerDB.setLastName(passenger.getLastName());
        passengerDB.getTicketList().add(passenger.getTicket());

        ticketRepository.create(passenger.getTicket());

        passengerDB = passengerEJB.createPassenger(passengerDB);
        passengerList = passengerEJB.findPassengers();

        conversation.end();
        return "allpassengers";
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public List<com.realdolmen.ex.domain.Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<com.realdolmen.ex.domain.Passenger> passengerList) {
        this.passengerList = passengerList;
    }
}
