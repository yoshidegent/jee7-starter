package com.realdolmen.course.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by YDEAX41 on 9/09/2015.
 */
@Embeddable
public class PassengerId implements Serializable {

    private String ssn;
    private String lastName;

    public PassengerId(){}

    public PassengerId(String ssn, String lastName) {
        this.ssn = ssn;
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerId that = (PassengerId) o;

        if (ssn != null ? !ssn.equals(that.ssn) : that.ssn != null) return false;
        return !(lastName != null ? !lastName.equals(that.lastName) : that.lastName != null);

    }

    @Override
    public int hashCode() {
        int result = ssn != null ? ssn.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
