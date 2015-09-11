package com.realdolmen.ex.domain;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
@Entity
public class DomesticFlight extends Flight {

    private String airlineCompany;

    @ElementCollection
    @Column(name = "refs")
    private List<String> references = new ArrayList<>();

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }
}
