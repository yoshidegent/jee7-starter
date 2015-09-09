package com.realdolmen.ex;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
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
        passenger.setPassengerType(Passenger.PassengerType.OCCASIONAL);
        passenger.setFrequentFlyerMiles(0);
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