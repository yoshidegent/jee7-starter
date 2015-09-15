package com.realdolmen.ex.ejb;

import com.realdolmen.ex.domain.Passenger;
import com.realdolmen.ex.ejb.interfaces.RemotePassengerEJB;
import com.realdolmen.ex.persistence.PassengerRepository;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class PassengerEJB implements RemotePassengerEJB {

    @EJB
    private PassengerRepository passengerRepository;

    @Override
    public List<Passenger> findPassengers() {
        return passengerRepository.findAll(Passenger.class);
    }

    @Override
    public Passenger findPassenger(Long id) {
        return passengerRepository.findById(Passenger.class, id);
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.create(passenger);
    }

    @Override
    public void deletePassenger(Passenger passenger) {
        passengerRepository.delete(passenger);
    }

    @Override
    public Passenger updatePassenger(Passenger passenger) {
        return passengerRepository.update(passenger);
    }
}
