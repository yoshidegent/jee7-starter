package be.ticket.resource;

import javax.ejb.AsyncResult;
import javax.ejb.Stateless;
import java.util.concurrent.*;

/**
 * Created by MLPAU49 on 12/09/2014.
 */

@Stateless
public class PaymentEJB {

    public Future<String> payByCreditCard() {
        return new AsyncResult<String>("foobar");
    }
}
