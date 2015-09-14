package com.realdolmen.ex.persistence;

import com.realdolmen.course.persistence.DataSetPersistenceTest;
import com.realdolmen.ex.domain.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PassengerRepositoryTest extends DataSetPersistenceTest {
    private static PassengerRepository passengerRepository;
    private static List<Passenger> passengerList;

    private static final int LIST_SIZE_PASSENGERS = 10;
    private static final int LIST_SIZE_TICKETS = 3;

    @Before
    public void before() {
        passengerRepository = new PassengerRepository();
        passengerRepository.entityManager = entityManager();

        passengerList = new ArrayList<>();

        for (int i = 0; i < LIST_SIZE_PASSENGERS; i++) {

            Passenger passenger = new Passenger();
            passenger.setFirstName("someFirstName" + i);
            passenger.setLastName("someLastName" + i);
            passenger.setPassengerType(PassengerType.OCCASIONAL);
            passenger.setPreferences(new ArrayList<String>(Arrays.asList(i + ":pref1", i + ":pref2", i + "pref3")));
            passenger.setSsn(i + "");
            passenger.setDateOfBirth(new Date());

            Address address = new Address();

            address.setStreet1("street1Test" + i);
            address.setStreet2("street2Test" + i);
            address.setZipCode("zipcodeTest" + i);
            address.setCountry("countryTest" + i);
            address.setCity("testCity" + i);

            passenger.setAddress(address);

            DomesticFlight flight = new DomesticFlight();
            flight.setNumber(i + "");
            flight.setAirlineCompany("someAirlineCompany" + i);
            flight.setReferences(new ArrayList<String>(Arrays.asList(i + ":ref1", i + ":ref2", i + ":ref3")));
            flight.setDepartureTime(new Date());
            flight.setArrivalTime(new Date());


            List<Ticket> ticketList = new ArrayList<>();

            for (int j = 0; j < LIST_SIZE_TICKETS; j++) {
                Ticket ticket = new Ticket();
                ticket.setPrice(100.0 + i + j);
                ticket.setFlight(flight);

                ticketList.add(ticket);
            }

            passenger.setTicketList(ticketList);

            passengerList.add(passenger);
            passengerRepository.create(passenger);
        }
    }

//  Methods tested:
//  List<String> findAllLastNames();
//  Integer totalFrequentFlyerMiles();
//  List<Ticket> findTicketsByPassengerId(Long passengerId);
//  void deleteAll();

    @Test
    @Ignore
    public void testFindAllLastNames() {
        //TODO: To be implemented
        fail("To be implemented");
    }

    @Test
    @Ignore
    public void testTotalFrequentFlyerMiles() {
        //TODO: To be implemented
        fail("To be implemented");
    }

    @Test
    @Ignore
    public void testFindTicketsByPassengerId() {
        //TODO: To be implemented
        fail("To be implemented");
    }

    @Test
    @Ignore
    public void deleteAll() {
        //TODO: To be implemented
        fail("To be implemented");
    }
}
