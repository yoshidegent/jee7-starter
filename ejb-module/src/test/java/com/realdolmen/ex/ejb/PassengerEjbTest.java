package com.realdolmen.ex.ejb;

import com.realdolmen.course.integration.RemoteBookRepositoryTest;
import com.realdolmen.ex.domain.*;
import com.realdolmen.ex.ejb.interfaces.RemotePassengerEJB;
import com.realdolmen.ex.persistence.GenericRepository;
import com.realdolmen.ex.persistence.PassengerRepository;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by YDEAX41 on 11/09/2015.
 */
public class PassengerEjbTest extends RemoteBookRepositoryTest{

    static final Logger LOG = LoggerFactory.getLogger(PassengerTest.class);

    @EJB
    private RemotePassengerEJB passengerEJB;

    private Passenger passenger;

    @Before
    public void before()
    {
        passenger = new Passenger();
        passenger.setFirstName("Yoshi");
        passenger.setLastName("Degent");
        passenger.setSsn("testSSN");
        passenger.setDateOfBirth(new GregorianCalendar(1993, 10, 19).getTime());
        passenger.setFlightTime(new GregorianCalendar(2015, 12, 31).getTime());
        passenger.setPassengerType(PassengerType.OCCASIONAL);
        passenger.setFrequentFlyerMiles(0);
        passenger.setPreferences(new ArrayList<String>(Arrays.asList("pref1", "pref2", "pref3")));

        CreditCard creditCard = new CreditCard();
        creditCard.setType(CreditCardType.VISA);
        creditCard.setControlNumber(1);
        creditCard.setExpireDate("2018/09");
        creditCard.setNumber("00000000000000000");

        List<CreditCard> creditCards = new ArrayList<>();
        creditCards.add(creditCard);

        passenger.setCreditCardList(creditCards);

        Address address = new Address();
        address.setStreet1("Some street 1");
        address.setStreet2("");
        address.setCity("Some City");
        address.setZipCode("0000");

        passenger.setAddress(address);
    }

    @Test
    public void testPassengerCreates() throws Exception
    {
        passengerEJB = lookup("ear-module-1.1/ejb-module-1.1/PassengerEJB!com.realdolmen.ex.ejb.interfaces.RemotePassengerEJB");
       // passengerEJB.setEntityManager(entityManager());
        passenger = passengerEJB.createPassenger(passenger);
        assertNotNull(passenger.getId());
    }
}
