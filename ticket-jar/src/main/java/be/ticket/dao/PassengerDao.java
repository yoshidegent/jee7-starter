package be.ticket.dao;

import be.ticket.entity.Passenger;
import be.ticket.entity.PassengerType;

import javax.ejb.*;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

@Stateless
@LocalBean
@Named
public class PassengerDao implements PassengerDaoRemote {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Passenger p) {
        entityManager.persist(p);
    }

    @Override
    public Passenger find(Integer id) {
        return entityManager.find(Passenger.class, id);
    }

    public Passenger createPassenger(String firstName, String lastName) {
        Passenger passenger = new Passenger("", "", new Date(), PassengerType.REGULAR);
        entityManager.persist(passenger);
        return passenger;
    }

    public List<Passenger> findAll() {
        return entityManager.createQuery(
            "select p from Passenger p", Passenger.class
        ).getResultList();
    }
}
