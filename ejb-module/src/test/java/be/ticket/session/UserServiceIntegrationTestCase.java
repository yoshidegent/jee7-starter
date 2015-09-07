package be.ticket.session;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import be.ticket.common.AbstractArquillianTestCase;
import be.ticket.entity.User;
import be.ticket.error.InvalidUserException;

@RunWith(Arquillian.class)
public class UserServiceIntegrationTestCase extends AbstractArquillianTestCase {

	@Inject
	UserService userService;

	@Test
	public void testFindAllUsers() {
		List<User> result = userService.findAllUsers();
		assertNotNull("Find all on Users illegally returned null", result);
		assertTrue("Find all on Users failed to return any data",
				result.size() > 0);
	}

	@Test
	public void testCreateValidUser() {
		User user = new User("Sansa", "Stark", "Sansa.Stark@redoair.be",
				"sstark");
		assertNull("Expected User identifier to be null", user.getId());
		try {
			userService.createUser(user);
		} catch (InvalidUserException e) {
			fail("Create on User should not be invalid!");
		}
		assertNotNull("Expected User identifier to no longer be null",
				user.getId());
	}
	
	@Test(expected=InvalidUserException.class)
	public void testCreateInvalidUser() throws InvalidUserException {
		User user = new User("Theo", "Tester", "Theo.Tester@redoair.be",
				"ttester");
		assertNull("Expected User identifier to be null", user.getId());
		userService.createUser(user);
	}
	
	@Test
	public void testFindUser() {
		User user = userService.findUser(1L);
		assertNotNull("Find on Users illegally returned null for id '1'", user);
		assertEquals("Find on Users returned an incorrect identifier", 1L, user
				.getId().longValue());
	}

	@Test
	public void testUpdateUser() {
		User user = userService.findUser(3L);
		user.setFirstName("testUpdateFirstName");
		Long currentVersion = user.getVersion();
		User updated = userService.updateUser(user);
		assertEquals(
				"Identifier of updated User is not the same as identifier of original User",
				updated.getId().longValue(), 3L);
		assertTrue(
				"Version for User failed to increment on update",
				(currentVersion != null && updated.getVersion() > currentVersion));
	}
	
	@Test
	public void testDeleteUser() {
		User user = userService.findUser(4L);
		userService.deleteUser(user);
		assertNull("Failed to remove User with identifier '4'",
				userService.findUser(4L));
	}
	
	@Test
	public void testValidateUserName() {
		assertTrue("User name expected to be valid", userService.validUserName("validUserName"));
		assertFalse("User name expected to be invalid", userService.validUserName("ttester"));
	}
}
