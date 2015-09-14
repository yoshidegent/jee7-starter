package com.realdolmen.ex.ejb;

import com.realdolmen.course.integration.RemoteBookRepositoryTest;
import com.realdolmen.course.persistence.DataSetPersistenceTest;
import com.realdolmen.course.persistence.RemoteBookRepository;
import com.realdolmen.ex.InitTestPassenger;
import com.realdolmen.ex.domain.Passenger;
import com.realdolmen.ex.ejb.interfaces.RemotePaymentEJB;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import java.util.concurrent.ExecutionException;

/**
 * Created by YDEAX41 on 14/09/2015.
 */
public class PaymentEjbTest extends RemoteBookRepositoryTest{

    static final Logger logger = LoggerFactory.getLogger(PassengerEjbTest.class);

    private RemotePaymentEJB payementEJB;
    private Passenger passenger;

    @Before
    public void before() throws Exception
    {
        payementEJB = lookup("ear-module-1.1/ejb-module-1.1/PaymentEJB!com.realdolmen.ex.ejb.interfaces.RemotePaymentEJB");
        passenger = InitTestPassenger.initPassenger();
    }

    @Test
    public void testPayByCreditCard() throws Exception
    {
        String result = payementEJB.payByCreditCard(passenger, 0).get();
        assertFalse(result == null || result.isEmpty());
    }
}
