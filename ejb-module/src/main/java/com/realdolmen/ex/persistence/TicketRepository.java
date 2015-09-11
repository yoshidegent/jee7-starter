package com.realdolmen.ex.persistence;

import com.realdolmen.ex.domain.Ticket;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
public class TicketRepository extends GenericRepository<Ticket> {
    public TicketRepository(Class<Ticket> persistentClass) {
        super(persistentClass);
    }
}
