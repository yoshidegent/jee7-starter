package be.ticket;

import be.ticket.common.AbstractArquillianTestCase;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.util.concurrent.Future;

@RunWith(Arquillian.class)
public class AsyncBeanTest extends AbstractArquillianTestCase {
    @EJB
    private AsyncBean asyncBean;

    @Test
    public void testAsync() throws Exception {
        Future<Integer> result = asyncBean.whatIsTheAnswerToLifeTheUniverseAndEverything();
        System.out.println("**************ASYNC CLIENT CALL RETURNED");
        Integer integer = result.get();
        Assert.assertEquals(42, integer.intValue());

    }
}
