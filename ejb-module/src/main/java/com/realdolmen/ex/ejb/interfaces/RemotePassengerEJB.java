package com.realdolmen.ex.ejb.interfaces;

import com.realdolmen.ex.domain.Passenger;

import javax.ejb.Remote;
import javax.persistence.EntityManager;
import java.util.List;

@Remote
public interface RemotePassengerEJB {
    List<Passenger> findPassengers();
    Passenger findPassenger(Long id);
    Passenger createPassenger(Passenger passenger);
    void deletePassenger(Passenger passenger);
    Passenger updatePassenger(Passenger passenger);
    void setEntityManager(EntityManager entityManager);
}
