package be.ticket.session;

import be.ticket.common.AbstractArquillianTestCase;
import be.ticket.dao.FlightDao;
import be.ticket.dao.PassengerDao;
import be.ticket.entity.InternationalFlight;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

@RunWith(Arquillian.class)
public class TicketRegistrationTest extends AbstractArquillianTestCase {
    @EJB
    private TicketBookingService bookingService;

    /**
     * Only used for the fixture, since I haven't setup DBUnit-ish stuff.
     */
    @EJB
    private PassengerDao passengerDao;

    /**
     * Only used for the fixture, since I haven't setup DBUnit-ish stuff.
     */
    @EJB
    private FlightDao flightDao;

    /**
     * Prep the database with some test data to run the unit test against.
     * Would be better done with DBUnit or so.
     */
    @Before
    public void prepareTestCase() {
        passengerDao.createPassenger("Jimi", "Hendrix");
        flightDao.create(new InternationalFlight("FL001", false));
    }

    @Test
    public void ticketCanBeBooked() throws Exception {
        bookingService.selectFlight("FL001");
        bookingService.selectPassenger(1);
        bookingService.bookTicket();

        Thread.sleep(2000); // Allow the scheduler to run at least once, so we can eye-ball assert that it runs
    }
}
