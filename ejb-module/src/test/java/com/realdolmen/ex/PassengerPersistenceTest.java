package com.realdolmen.ex;

import com.realdolmen.course.domain.*;
import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by YDEAX41 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest
{
    static final Logger logger = LoggerFactory.getLogger(PassengerPersistenceTest.class);

    @Test
    public void testPassengerPersists() throws Exception
    {
        Passenger passenger = new Passenger();
        passenger.setFirstName("Yoshi");
        passenger.setLastName("Degent");
        passenger.setSsn("testSSN");
        passenger.setDateOfBirth(new GregorianCalendar(1993, 10, 19).getTime());
        passenger.setFlightTime(new GregorianCalendar(2015, 12, 31).getTime());
        passenger.setPassengerType(PassengerType.OCCASIONAL);
        passenger.setFrequentFlyerMiles(0);

        CreditCard creditCard = new CreditCard();
        creditCard.setType(CreditCardType.VISA);
        creditCard.setControlNumber(1);
        creditCard.setExpireDate("2018/09");
        creditCard.setNumber("00000000000000000");

        List<CreditCard> creditCards = new ArrayList<>();
        creditCards.add(creditCard);

        passenger.setCreditCard(creditCards);

        Address address = new Address();
        address.setStreet1("Some street 1");
        address.setStreet2("");
        address.setCity("Some City");
        address.setZipCode("0000");

        passenger.setAddress(address);

        entityManager().persist(passenger);

        logger.info("New passenger id: " + passenger.getId());

        org.junit.Assert.assertNotNull(passenger.getId());
    }

    @Test
    public void testPassengerGetAll()
    {
        Query q = entityManager().createQuery("SELECT p FROM Passenger p");

        List resultList = q.getResultList();

        if(!resultList.isEmpty())
        {
            for(Object passenger : resultList)
            {
                logger.info(passenger.toString());
            }
            assertTrue(resultList.get(0) instanceof Passenger);
        }
        else
            fail("List was empty.");
    }
}
