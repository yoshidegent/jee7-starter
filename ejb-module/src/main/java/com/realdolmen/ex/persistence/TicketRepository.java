package com.realdolmen.ex.persistence;

import com.realdolmen.ex.domain.Ticket;
import com.realdolmen.ex.persistence.interfaces.ITicketRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
@Stateless
@LocalBean
public class TicketRepository extends GenericRepository<Ticket> implements ITicketRepository {
}
