package be.ticket.dao;

import be.ticket.entity.Passenger;

import javax.ejb.Remote;

@Remote
public interface PassengerDaoRemote {
    void save(Passenger p);
    Passenger find(Integer id);
}
