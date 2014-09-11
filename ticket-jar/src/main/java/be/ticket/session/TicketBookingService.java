package be.ticket.session;

import be.ticket.dao.FlightDao;
import be.ticket.dao.PassengerDao;
import be.ticket.dao.PassengerDaoRemote;
import be.ticket.dao.TicketDao;
import be.ticket.entity.Flight;
import be.ticket.entity.Passenger;
import be.ticket.entity.Ticket;

import javax.ejb.*;
import java.util.Date;
import java.util.List;

@Stateful
public class TicketBookingService {
    @EJB
    private PassengerDao passengerDao;

    @EJB
    private FlightDao flightDao;

    @EJB
    private TicketDao ticketDao;

    private Passenger passenger;
    private Flight flight;

    public void selectPassenger(Integer id) {
        passenger = passengerDao.find(id);
    }

    public void selectFlight(String number) {
        flight = flightDao.findByNumber(number);
    }

    @Remove
    public void bookTicket() {
        Ticket ticket = new Ticket(100, new Date());
        ticket.setPassenger(passenger);
        ticket.setFlight(flight);
        ticketDao.create(ticket);
    }
}
