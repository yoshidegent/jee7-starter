package com.realdolmen.course.integration;

import org.junit.Before;
import org.junit.Test;

import javax.jms.*;

public class RemoteJmsTest extends RemoteIntegrationTest {
    private ConnectionFactory connectionFactory;
    private Queue queue;

    @Before
    public void initializeJms() throws Exception {
        connectionFactory = lookup("jms/RemoteConnectionFactory");
        queue = lookup("jms/queue/MyQueue");
    }

    @Test
    public void produceTextMessage() throws Exception {
        Connection connection = connectionFactory.createConnection("root", "root");
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(queue);
        producer.send(session.createTextMessage("Hello World!"));
    }
}
