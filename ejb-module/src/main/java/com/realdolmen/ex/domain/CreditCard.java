package com.realdolmen.ex.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
@Embeddable
public class CreditCard implements Serializable {
    private String number;
    private String expireDate;
    private Integer controlNumber;
    private CreditCardType type;

    public CreditCard(){}

    public CreditCard(String number, String expireDate, Integer controlNumber, CreditCardType type) {
        this.number = number;
        this.expireDate = expireDate;
        this.controlNumber = controlNumber;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Integer controlNumber) {
        this.controlNumber = controlNumber;
    }

    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }
}
