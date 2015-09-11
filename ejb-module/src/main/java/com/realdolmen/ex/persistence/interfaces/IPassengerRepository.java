package com.realdolmen.ex.persistence.interfaces;

import com.realdolmen.ex.domain.Passenger;
import com.realdolmen.ex.domain.Ticket;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IPassengerRepository
{
    List<String> findAllLastNames();
    Integer totalFrequentFlyerMiles();
    List<Ticket> findTicketsByPassengerId(Long passengerId);
    void deleteAll();
}
