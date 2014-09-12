package be.ticket.dao;

import be.ticket.entity.Passenger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PassengerRepositoryBean implements PassengerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Passenger find(Integer id) {
        return entityManager.find(Passenger.class, id);
    }
}
