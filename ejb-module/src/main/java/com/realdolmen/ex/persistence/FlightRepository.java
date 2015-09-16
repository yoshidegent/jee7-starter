package com.realdolmen.ex.persistence;

import com.realdolmen.ex.domain.Flight;
import com.realdolmen.ex.persistence.interfaces.IFlightRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class FlightRepository extends GenericRepository<Flight> implements IFlightRepository {
}
