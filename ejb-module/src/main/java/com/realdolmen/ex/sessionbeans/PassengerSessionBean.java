package com.realdolmen.ex.sessionbeans;

import com.realdolmen.ex.domain.Address;
import com.realdolmen.ex.domain.CreditCard;
import com.realdolmen.ex.domain.Passenger;
import com.realdolmen.ex.domain.Ticket;
import com.realdolmen.ex.ejb.PassengerEJB;
import com.realdolmen.ex.ejb.PaymentEJB;
import com.realdolmen.ex.persistence.TicketRepository;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;

/**
 * Created by YDEAX41 on 14/09/2015.
 */
@Stateful
public class PassengerSessionBean {
    private Passenger passenger;
    @EJB
    private PassengerEJB passengerEJB;
    @EJB
    private PaymentEJB paymentEJB;

    public PassengerSessionBean() {
    }

    public PassengerSessionBean(Passenger passenger) {
        initPassenger(passenger);
    }

    public void initPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setAddressOfPassenger(Address address) {
        passenger.setAddress(address);
    }

    public void addCreditCardToPassenger(CreditCard creditCard) {
        passenger.getCreditCardList().add(creditCard);
    }

    public void addTicketToPassenger(Ticket ticket)
    {
        TicketRepository ticketRepository = new TicketRepository(Ticket.class);
        ticketRepository.create(ticket);
        passenger.getTicketList().add(ticket);
    }

    @Remove
    public void checkout(int creditCardIndex)
    {
        passengerEJB.createPassenger(passenger);
        paymentEJB.payByCreditCard(passenger, creditCardIndex);
    }
}
