package com.realdolmen.ex.persistence.interfaces;

import com.realdolmen.ex.domain.Passenger;
import com.realdolmen.ex.domain.Ticket;

import java.util.List;

/**
 * Created by YDEAX41 on 11/09/2015.
 */
public interface IPassengerRepository
{
    List<String> findAllLastNames();
    Integer totalFrequentFlyerMiles();
    List<Ticket> findTicketsByPassengerId(Long passengerId);
    void deleteAll();
}
