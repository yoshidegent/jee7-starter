package com.realdolmen.ex.ejb;

import com.realdolmen.ex.domain.CreditCard;
import com.realdolmen.ex.domain.Passenger;
import com.realdolmen.ex.ejb.interfaces.RemotePaymentEJB;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
import java.util.concurrent.Future;

@Stateless
@LocalBean
public class PaymentEJB implements RemotePaymentEJB
{
    @Asynchronous
    public Future<String> payByCreditCard(Passenger passenger, int creditCardIndex)
    {
        List<CreditCard> creditCardList = passenger.getCreditCardList();
        CreditCard creditCardToPayWith = null;

        String resultString;


        if(creditCardList.size() > creditCardIndex)
        {
            creditCardToPayWith = creditCardList.get(creditCardIndex);
            resultString = "Payment executed with CreditCard: " + creditCardToPayWith.getNumber();
        }
        else
        {
            resultString = "Payment not executed, something went wrong";
        }

        return new AsyncResult<>(resultString);
    }
}
