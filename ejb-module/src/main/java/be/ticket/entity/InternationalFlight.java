package be.ticket.entity;

import javax.persistence.Entity;

@Entity
public class InternationalFlight extends Flight {
    private Boolean blacklisted;

    private InternationalFlight() {
    }

    public InternationalFlight(String number, boolean blacklisted) {
        super(number);
        this.blacklisted = blacklisted;
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }
}
