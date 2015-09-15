package com.realdolmen.ex.persistence;

import com.realdolmen.ex.domain.Address;
import com.realdolmen.ex.domain.Passenger;
import com.realdolmen.ex.domain.PassengerType;
import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by YDEAX41 on 11/09/2015.
 */
public class PassengerRepositoryCrudTest extends DataSetPersistenceTest
{

    private PassengerRepository passengerRepository;
    private Passenger passenger;

    @Before
    public void before()
    {
        passengerRepository = new PassengerRepository();
        passengerRepository.entityManager = entityManager();

        passenger = new Passenger();
        passenger.setFirstName("someFirstName");
        passenger.setLastName("someLastName");
        passenger.setPassengerType(PassengerType.OCCASIONAL);
        passenger.setPreferences(new ArrayList<String>(Arrays.asList("pref1", "pref2", "pref3")));
        passenger.setSsn("1111111");
        passenger.setDateOfBirth(new Date());

        Address address = new Address();

        address.setStreet1("street1Test");
        address.setStreet2("street2Test");
        address.setZipCode("zipcodeTest");
        address.setCountry("countryTest");
        address.setCity("testCity");

        passenger.setAddress(address);
    }

    @Test
    public void testPassengerPersists()
    {
        passenger = passengerRepository.create(passenger);

        assertNotNull(passenger.getId());
    }

    @Test
    public void testPassengerUpdates()
    {
        passenger = passengerRepository.create(passenger);

        String firstNameBeforeUpdate = passenger.getFirstName();
        passenger.setFirstName("someUpdatedFirstName");
        passenger = passengerRepository.update(passenger);

        assertNotEquals(passenger.getFirstName(), firstNameBeforeUpdate);
    }

    @Test
    @Ignore
    public void testPassengerCanBeDeleted()
    {
        //TODO: test still failing
        passenger = passengerRepository.create(passenger);

        passengerRepository.delete(passenger);
        assertNull(passenger.getId());
    }

    @Test
    @Ignore
    public void testPassengerCanBeFoundById()
    {
        //TODO: test still failing
        Long id = passenger.getId();

        Passenger passengerToCompare = passengerRepository.findById(Passenger.class, id);

        assertEquals(passenger, passengerToCompare);
    }

    @Test
    @Ignore
    public void testAllPassengersCanBeFound()
    {
        //TODO: To be implemented
        fail("To be implemented");
    }
}
