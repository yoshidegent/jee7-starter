package com.realdolmen.ex.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ticket implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
