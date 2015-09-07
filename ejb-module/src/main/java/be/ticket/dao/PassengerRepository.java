package be.ticket.dao;

import be.ticket.entity.Passenger;

import javax.ejb.Remote;

@Remote
public interface PassengerRepository {
    Passenger find(Integer id);
}
