package com.realdolmen.ex.domain;

import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
public class FlightTest extends DataSetPersistenceTest
{
    private Flight flight;

    @Test
    public void testDomesticFlightPersists() throws Exception
    {
        flight = new DomesticFlight();
        flight.setNumber("000000");
        flight.setArrivalTime(new Date());
        flight.setDepartureTime(new Date());
        ((DomesticFlight) flight).setAirlineCompany("someCompany");
        ((DomesticFlight) flight).setReferences(new ArrayList<String>(Arrays.asList("ref1", "ref2", "ref3")));

        entityManager().persist(flight);

        entityManager().flush();

        assertNotNull(flight.getId());
    }

    @Test
    public void testInternationalFlightPersists() throws Exception
    {
        flight = new InternationalFlight();
        flight.setNumber("000000");
        flight.setArrivalTime(new Date());
        flight.setDepartureTime(new Date());
        ((InternationalFlight) flight).setRegulations("someRegulation");

        entityManager().persist(flight);

        assertNotNull(flight.getId());
    }
}
