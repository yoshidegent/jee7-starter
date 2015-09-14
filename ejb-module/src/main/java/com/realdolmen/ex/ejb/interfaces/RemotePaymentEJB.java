package com.realdolmen.ex.ejb.interfaces;

import com.realdolmen.ex.domain.Passenger;

import javax.ejb.Remote;
import java.util.concurrent.Future;

@Remote
public interface RemotePaymentEJB {
    Future<String> payByCreditCard(Passenger passenger, int creditCardIndex);
}
