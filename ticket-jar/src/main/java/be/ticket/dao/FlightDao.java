package be.ticket.dao;

import be.ticket.entity.Flight;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class FlightDao extends AbstractDAO<Flight> {
    public Flight findByNumber(String number) {
        TypedQuery<Flight> query = em.createQuery("select f from Flight f where f.number = :number", Flight.class);
        query.setParameter("number", number);
        return query.getSingleResult();
    }
}
