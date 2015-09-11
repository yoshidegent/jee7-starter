package com.realdolmen.ex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
@Entity
public class Ticket implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    private double price;
    
    @OneToOne
    private Flight flight;

    public void setPrice(Double price) {
        if(price < 0)
            this.price = 0;
        else
            this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }
}
