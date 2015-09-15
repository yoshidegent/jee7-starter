package com.realdolmen.ex.ejb;

import com.realdolmen.ex.domain.Passenger;
import com.realdolmen.ex.ejb.interfaces.RemotePassengerEJB;
import com.realdolmen.ex.persistence.PassengerRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class PassengerEJB implements RemotePassengerEJB{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Passenger> findPassengers() {
        PassengerRepository passengerRepository = this.getRepo();
        if(!passengerRepository.checkEntityManagerIsNull())
            return passengerRepository.findAll(Passenger.class);
        else
            return null;
    }

    @Override
    public Passenger findPassenger(Long id) {
        PassengerRepository passengerRepository = this.getRepo();
        if(!passengerRepository.checkEntityManagerIsNull())
            return passengerRepository.findById(Passenger.class, id);
        else
            return null;
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        PassengerRepository passengerRepository = this.getRepo();
        if(!passengerRepository.checkEntityManagerIsNull())
            return passengerRepository.create(passenger);
        else
            return null;
    }

    @Override
    public void deletePassenger(Passenger passenger) {
        PassengerRepository passengerRepository = this.getRepo();

        if(!passengerRepository.checkEntityManagerIsNull())
            passengerRepository.delete(passenger);
    }

    @Override
    public Passenger updatePassenger(Passenger passenger) {
        PassengerRepository passengerRepository = this.getRepo();

        if(!passengerRepository.checkEntityManagerIsNull())
            return passengerRepository.update(passenger);
        else
            return null;
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private PassengerRepository getRepo()
    {
        PassengerRepository passengerRepository = new PassengerRepository();
        if(passengerRepository.checkEntityManagerIsNull())
        {
            passengerRepository.setEntityManager(entityManager);
        }
        return passengerRepository;
    }
}
