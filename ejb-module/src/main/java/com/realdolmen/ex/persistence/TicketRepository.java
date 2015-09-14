package com.realdolmen.ex.persistence;

import com.realdolmen.ex.domain.Ticket;
import com.realdolmen.ex.persistence.interfaces.ITicketRepository;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
public class TicketRepository extends GenericRepository<Ticket> implements ITicketRepository {
    public TicketRepository(Class<Ticket> persistentClass) {
        super(persistentClass);
    }
}
