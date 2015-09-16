package com.realdolmen.ex.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
@Entity
public abstract class Flight extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;

    public void setDepartureTime(Date date) {
        this.departureTime = date;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getId() {
        return id;
    }
}
