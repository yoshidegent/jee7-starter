package be.ticket.jms;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import be.ticket.common.AbstractArquillianTestCase;

@RunWith(Arquillian.class)
public class TicketPrinterMDBIntegrationTestCase extends AbstractArquillianTestCase {

	@Resource(mappedName = "/ConnectionFactory")
	ConnectionFactory connectionFactory;
	@Resource(mappedName = "/queue/test")
	Queue queue;

	@Test
	public void testSendTextMessage() { 
		Connection connection = null;
		try {
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			MessageProducer publisher = session.createProducer(queue);
			TextMessage message = session.createTextMessage("Hello World!");
			publisher.send(message);
		} catch (JMSException e) {
			fail("Unable to send message to TicketPrinterMDB using JMS");
		} finally {
			if (connection != null)   {
		        try {
		           connection.close();
		        } catch (JMSException e) {                    
		          fail("Unable to close JMS Connection");
		        }
		    } 
		}
	}

}
