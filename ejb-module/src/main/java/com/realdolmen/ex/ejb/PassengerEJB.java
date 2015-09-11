package com.realdolmen.ex.ejb;

import com.realdolmen.ex.domain.Passenger;
import com.realdolmen.ex.ejb.interfaces.RemotePassengerEJB;
import com.realdolmen.ex.persistence.PassengerRepository;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class PassengerEJB implements RemotePassengerEJB{

    private PassengerRepository  passengerRepository;

    @Override
    public List<Passenger> findPassengers() {
        passengerRepository = new PassengerRepository();
        return passengerRepository.findAll();
    }

    @Override
    public Passenger findPassenger(Long id) {
        passengerRepository = new PassengerRepository();
        return passengerRepository.findById(id);
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        passengerRepository = new PassengerRepository();
        return passengerRepository.create(passenger);
    }

    @Override
    public void deletePassenger(Passenger passenger) {
        passengerRepository = new PassengerRepository();
        passengerRepository.delete(passenger);
    }

    @Override
    public Passenger updatePassenger(Passenger passenger) {
        passengerRepository = new PassengerRepository();
        return passengerRepository.update(passenger);
    }
}
