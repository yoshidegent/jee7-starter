package be.ticket.entity;

import javax.persistence.Entity;

@Entity
public class DomesticFlight extends Flight {
    private String company;

    private DomesticFlight() {
    }
}
