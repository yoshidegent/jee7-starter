package com.realdolmen.course.domain;

import javax.persistence.*;

/**
 * Created by YDEAX41 on 9/09/2015.
 */
@Entity
@SecondaryTable(name = "passenger_meta")
public class Passenger
{
    @EmbeddedId
    private PassengerId id;

    private String firstName;

    @Column(table = "passenger_meta")
    private Integer frequentFlyerMiles;
    @Column(table = "passenger_meta")
    private byte[] picture;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public PassengerId getId() {
        return id;
    }

    public void setId(PassengerId id) {
        this.id = id;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
