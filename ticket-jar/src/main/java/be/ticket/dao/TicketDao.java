package be.ticket.dao;

import be.ticket.entity.Ticket;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Stateless
public class TicketDao extends AbstractDAO<Ticket> {
    public List<Ticket> findByDate() {
        TypedQuery<Ticket> query = em.createQuery("select t from Ticket t where t.dateOfDeparture <= :date", Ticket.class);

        // We could set this also to say: "last week" to query all
        // tickets with a date bigger than last week.
        Date today = new Date();
        query.setParameter("date", today);

        return query.getResultList();
    }

}
