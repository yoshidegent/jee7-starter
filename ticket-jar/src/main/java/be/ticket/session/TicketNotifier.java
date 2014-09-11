package be.ticket.session;

import be.ticket.dao.TicketDao;
import be.ticket.entity.Ticket;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class TicketNotifier {
    @EJB
    private TicketDao ticketDao;

    /**
     * For demonstration purposes: run every second. More likely should be "every day"
     */
    //@Schedule(second = "0/1", minute = "*", hour = "*", persistent = false)
    public void doSomethingPeriodically() {
        List<Ticket> tickets = ticketDao.findByDate();
        for (Ticket ticket : tickets) {
            System.out.println("********************************");
            System.out.println("FAKE SENDING AN EMAIL");
            System.out.println("********************************");
            System.out.println(ticket);
            System.out.println("********************************");
        }
    }
}
