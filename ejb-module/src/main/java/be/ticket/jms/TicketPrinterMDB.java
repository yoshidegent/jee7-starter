package be.ticket.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test"),
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class TicketPrinterMDB implements MessageListener {
	@Inject
	Logger logger;
	
	public void onMessage(Message message) {
        delegateProcessing((TextMessage) message);
	}

    private void delegateProcessing(TextMessage message) {
        try {
            System.out.println("******************");
            System.out.println("RECEVEIVED MESSAGE");
            System.out.println("******************");
            logger.info("Received message " + message.getText());
        } catch (JMSException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
