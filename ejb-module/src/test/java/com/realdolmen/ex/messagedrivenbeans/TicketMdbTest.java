package com.realdolmen.ex.messagedrivenbeans;

import com.realdolmen.course.integration.RemoteJmsTest;
import org.junit.*;

import javax.jms.TextMessage;

/**
 * Created by YDEAX41 on 15/09/2015.
 */
public class TicketMdbTest extends RemoteJmsTest
{
    private String messageString = "";

    @Before
    public void before()
    {
        messageString += "1000,100.0\n";
        messageString += "2000,200.0\n";
        messageString += "3000,300.0\n";
    }

    @Test
    public void testMessageReceived() throws Exception
    {
        TextMessage message = session.createTextMessage(messageString);
        producer.send(message);
    }
}
