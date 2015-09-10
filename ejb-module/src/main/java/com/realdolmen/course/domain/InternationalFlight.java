package com.realdolmen.course.domain;

import javax.persistence.Entity;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
@Entity
public class InternationalFlight extends Flight {
    private boolean blackListed;

    private String regulations;

    public InternationalFlight() {
        this.blackListed = false;
    }

    public boolean isBlackListed() {
        return blackListed;
    }

    public void setBlackListed(boolean blackListed) {
        this.blackListed = blackListed;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }
}
