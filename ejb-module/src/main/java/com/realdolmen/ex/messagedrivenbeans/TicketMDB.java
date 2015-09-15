package com.realdolmen.ex.messagedrivenbeans;

import com.realdolmen.ex.domain.Ticket;
import com.realdolmen.ex.persistence.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Arrays;
import java.util.List;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/MyQueue")})
public class TicketMDB implements MessageListener {

    static final Logger logger = LoggerFactory.getLogger(TicketMDB.class);

    @EJB
    private TicketRepository ticketRepository;

    public TicketMDB() {
    }

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
            String lines[] = textMessage.getText().split("\\r?\\n");
            for(int i=0; i<lines.length; i++)
            {
                List<String> stringList = Arrays.asList(lines[i].split(","));

                String ticketIdString = stringList.get(0);
                String ticketPriceString = stringList.get(1);

                logger.info("id:" + ticketIdString + ", price:" + ticketPriceString);

                Long ticketId;
                double ticketPrice;

                try
                {
                    ticketId = Long.parseLong(ticketIdString);
                }
                catch (NumberFormatException nfe)
                {
                    ticketId = null;
                }

                try
                {
                    ticketPrice = Double.parseDouble(ticketPriceString);
                }
                catch (NumberFormatException nfe)
                {
                    ticketPrice = 0;
                }

                if(stringList.size() == 3)
                {
                    //TODO: implement a message with 3 columns
                }

                Ticket ticket = new Ticket();
                ticket.setId(ticketId);
                ticket.setPrice(ticketPrice);

                ticketRepository.update(ticket);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
