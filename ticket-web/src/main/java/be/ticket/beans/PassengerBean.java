package be.ticket.beans;

import be.ticket.dao.PassengerDao;
import be.ticket.entity.AccountNumber;
import be.ticket.entity.Passenger;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class PassengerBean {
    @EJB
    private PassengerDao passengerDao;

    private AccountNumber number;

    /**
     * Passenger under creation.
     */
    private Passenger passenger = new Passenger();

    public List<Passenger> getPassengers() {
        return passengerDao.findAll();
    }

    public Passenger getPassenger() {
        return this.passenger;
    }

    public String save() {
        passengerDao.save(this.passenger);
        return "passengers.xhtml";
    }
}
