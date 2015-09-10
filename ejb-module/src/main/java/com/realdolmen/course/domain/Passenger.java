package com.realdolmen.course.domain;

import javax.persistence.*;
import javax.persistence.metamodel.ListAttribute;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by YDEAX41 on 9/09/2015.
 */
@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(updatable = false)
    private String ssn;

    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;

    private Integer frequentFlyerMiles;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(updatable = false)
    private Date dateOfBirth;

    @Transient
    private Integer age;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PassengerType passengerType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date flightTime;

    @ElementCollection
    private List<CreditCard> creditCard;

    @Embedded
    private Address address;

    @ElementCollection
    private List<String> preferences;

    public long getId() {
        return id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        setAge(calculateAge(dateOfBirth));
    }

    public Integer getAge() {
        return age;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public Date getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Date flightTime) {
        this.flightTime = flightTime;
    }

    public List<CreditCard> getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(List<CreditCard> creditCard) {
        this.creditCard = creditCard;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer calculateAge(Date dateOfBirth) {
        Calendar calendarBirth = Calendar.getInstance();
        calendarBirth.setTime(dateOfBirth);
        //setup calNow as today.
        Calendar calNow = Calendar.getInstance();
        calNow.setTime(new java.util.Date());
        //calculate age in years.
        int ageYr = (calNow.get(Calendar.YEAR) - calendarBirth.get(Calendar.YEAR));
        // calculate additional age in months, possibly adjust years.
        int ageMo = (calNow.get(Calendar.MONTH) - calendarBirth.get(Calendar.MONTH));

        if (ageMo < 0) {
            //adjust years by subtracting one
            ageYr--;
        }
        return ageYr;
    }
}
