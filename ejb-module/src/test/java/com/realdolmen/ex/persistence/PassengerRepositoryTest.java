package com.realdolmen.ex.persistence;

import com.realdolmen.course.persistence.DataSetPersistenceTest;
import com.realdolmen.ex.domain.Address;
import com.realdolmen.ex.domain.Passenger;
import com.realdolmen.ex.domain.PassengerType;
import com.realdolmen.ex.domain.Ticket;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by YDEAX41 on 11/09/2015.
 */
public class PassengerRepositoryTest extends DataSetPersistenceTest
{
    private PassengerRepository passengerRepository;
    private List<Passenger> passengerList;
    private List<Ticket> tickets;

    private final int LIST_SIZE = 10;

    @Before
    public void before()
    {
        passengerRepository = new PassengerRepository();
        passengerRepository.entityManager = entityManager();

        for(int i=0; i<LIST_SIZE; i++) {

            Passenger passenger = new Passenger();
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

            passengerList.add(passenger);
            passengerRepository.create(passenger);
        }
    }
}
