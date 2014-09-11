package be.ticket.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ticket extends AbstractEntity {
  private double price;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Flight flight;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfDeparture;

    /**
     * Used by JPA.
     */
    protected Ticket() {
    }

    public Ticket(double price, Date dod) {
        this.price = price;
        this.dateOfDeparture = dod;
    }

    public void setPassenger(Passenger p) {
        this.passenger = p;
    }

    public double getPrice() {
        return price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "price=" + price +
                ", passenger=" + passenger +
                ", flight=" + flight +
                ", dateOfDeparture=" + dateOfDeparture +
                '}';
    }
}
