package be.ticket.future;

import be.ticket.common.AbstractArquillianTestCase;
import be.ticket.resource.PaymentEJB;
import org.junit.Test;

import javax.inject.Inject;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

/**
 * Created by MLPAU49 on 12/09/2014.
 */
public class FutureTest extends AbstractArquillianTestCase {

    @Inject
    private PaymentEJB paymentEJB;

    @Test
    public void test_payment() throws Exception {
        Future<String> future = paymentEJB.payByCreditCard();
        assertEquals("foobar", future.get());
    }
}
