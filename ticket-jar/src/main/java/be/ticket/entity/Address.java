package be.ticket.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String number;
    private String city;
    private String postalCode;

    /**
     * Used by JPA.
     */
    private Address() {
    }

    public Address(String street, String number, String city, String postalCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
