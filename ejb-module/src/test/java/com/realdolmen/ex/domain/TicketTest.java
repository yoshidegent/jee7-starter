package com.realdolmen.ex.domain;

import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
public class TicketTest extends DataSetPersistenceTest {

    private Ticket ticket;

    @Before
    public void before() {
        ticket = new Ticket();
        ticket.setPrice(100.0);
    }

    @After
    public void after()
    {
        ticket = null;
    }


    @Test
    public void testTicketPersits() throws Exception
    {
        entityManager().persist(ticket);

        Long ticketID = ticket.getId();
        assertNotNull(ticketID);
    }

    @Test
    public void testFlightCanBeAssignedToATicket()
    {
        Flight flight = new InternationalFlight();
        flight.setNumber("00000");
        flight.setDepartureTime(new Date());
        flight.setArrivalTime(new Date());

        ticket.setFlight(flight);

        entityManager().persist(flight);
        entityManager().persist(ticket);
        entityManager().flush();

        Long ticketId = ticket.getId();

        assertEquals(entityManager().find(Ticket.class, ticketId).getFlight().getId(), flight.getId());
    }

    @Test
    public void testTicketPriceMustNotBeNegative()
    {
        ticket.setPrice(-10.0);
        if(ticket.getPrice() < 0)
            fail("Price was negative.");
    }
}
