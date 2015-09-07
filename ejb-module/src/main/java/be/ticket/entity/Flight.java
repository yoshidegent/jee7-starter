package be.ticket.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Flight extends AbstractEntity {

    private String number;

    /**
     * Used by JPA.
     */
    protected Flight() {
    }

    public Flight(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
