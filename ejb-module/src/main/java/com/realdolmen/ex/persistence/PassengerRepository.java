package com.realdolmen.ex.persistence;

import com.realdolmen.ex.domain.Passenger;
import com.realdolmen.ex.domain.Ticket;
import com.realdolmen.ex.persistence.interfaces.IPassengerRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class PassengerRepository extends GenericRepository<Passenger> implements IPassengerRepository {

    @Override
    public List<String> findAllLastNames() {
        String queryString = "SELECT p.lastName FROM Passenger p";
        TypedQuery<String> query = entityManager.createQuery(queryString, String.class);
        return query.getResultList();
    }

    @Override
    public Integer totalFrequentFlyerMiles() {
        String queryString = "SELECT sum(p.frequentFlyerMiles) FROM Passenger p";
        TypedQuery<Integer> query = entityManager.createQuery(queryString, Integer.class);
        return query.getSingleResult();
    }

    @Override
    public List<Ticket> findTicketsByPassengerId(Long passengerId) {
        String queryString = "SELECT p.ticketList FROM Passenger p";
        TypedQuery<Ticket> query = entityManager.createQuery(queryString, Ticket.class);
        return query.getResultList();
    }

    @Override
    public void deleteAll() {
       // String queryString = "DELETE p FROM Passenger p";
       // TypedQuery<String> query = entityManager.createQuery(queryString, String.class);
    }
}
