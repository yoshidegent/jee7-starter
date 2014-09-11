package be.ticket.ws;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.BeforeClass;
import org.junit.Test;

import be.ticket.entity.User;

public class UserWebServiceIntegrationTestCase {

	private static UserWebService userWebService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		URL wsdlLocation = new URL("http://localhost:8080/ticket-web/UserWebService/UserWebServiceEndPoint?wsdl");
		QName serviceName = new QName("http://ws.ticket.be/", "UserWebService");
		Service service = Service.create(wsdlLocation, serviceName);
		userWebService = service.getPort(UserWebService.class);
	}

	@Test
	public void testFindAllUsers() {
		List<User> result = userWebService.findAllUsers();
		assertNotNull("Find all on UserWebService illegally returned null",
				result);
		assertTrue("Find all on UserWebService failed to return any data",
				result.size() > 0);
	}

}
