package com.realdolmen.ex;

import com.realdolmen.ex.domain.Passenger;
import com.realdolmen.ex.domain.PassengerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

/**
 * Created by YDEAX41 on 14/09/2015.
 */
public class InitTestPassenger
{
    public static Passenger initPassenger()
    {
        Passenger testPassenger = new Passenger();
        testPassenger.setFirstName("Yoshi");
        testPassenger.setLastName("Degent");
        testPassenger.setSsn("testSSN");
        testPassenger.setDateOfBirth(new GregorianCalendar(1993, 10, 19).getTime());
        testPassenger.setFlightTime(new GregorianCalendar(2015, 12, 31).getTime());
        testPassenger.setPassengerType(PassengerType.OCCASIONAL);
        testPassenger.setFrequentFlyerMiles(0);
        testPassenger.setPreferences(new ArrayList<String>(Arrays.asList("pref1", "pref2", "pref3")));

        return testPassenger;
    }
}
