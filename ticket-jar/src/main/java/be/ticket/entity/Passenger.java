package be.ticket.entity;


import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private PassengerType type;

    @Embedded
    private Address address;

    /**
     * Used by JPA.
     */
    public Passenger() {
    }

    public Passenger(String firstName, String lastName, Date birthDate, PassengerType type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public PassengerType getType() {
        return type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
