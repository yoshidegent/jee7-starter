package be.ticket.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserRESTServiceIntegrationTestCase {

	private static UserRESTService client;

	@BeforeClass
	public static void setupBeforeClass() {
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
		client = ProxyFactory.create(UserRESTService.class,
				"http://localhost:8080/ticket-web/resources");
	}

	@Test
	public void testFindAllUsers() {
		UserListWrapper result = client.findAllUsers();
		assertNotNull("Find all on UserRESTService illegally returned null",
				result.getUsers());
		assertTrue("Find all on UserRESTService failed to return any data",
				result.getUsers().size() > 0);
	}

}
