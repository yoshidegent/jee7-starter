package be.ticket.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import be.ticket.common.AbstractArquillianTestCase;
import be.ticket.entity.User;

@RunWith(Arquillian.class)
public class UserDAOIntegrationTestCase extends AbstractArquillianTestCase {

	@Inject
	UserDAO dao;

	@Test
	public void testCountUser() {
		long count = dao.count();
		assertTrue("Count on Users incorrectly reported there were no entries",
				count > 0);
	}

	@Test
	public void testFindUser() {
		User user = dao.find(1L);
		assertNotNull("Find on Users illegally returned null for id '1'", user);
		assertEquals("Find on Users returned an incorrect identifier", 1L, user
				.getId().longValue());
	}

	@Test
	public void testFindAllUsers() {
		long count = dao.count();
		assertTrue(
				"Too expensive to perform a find all test for Users, as there are "
						+ count + " entries", count < 250);
		List<User> result = dao.findAll();
		assertNotNull("Find all on Users illegally returned null", result);
		assertTrue("Find all on Users failed to return any data",
				result.size() > 0);
	}

	@Test
	public void testFindRangeUsers() {
		long count = dao.count();
		if (count > 5)
			count = 5;
		List<User> result = dao.findRange(0, (int) count);
		assertNotNull("Find range on Users illegally returned null", result);
		assertEquals(
				"Find range on Users returned an incorrect number of entries",
				count, result.size());
	}

	@Test
	public void testFindUsersByUserName() {
		List<User> result = dao.findUsersByUserName("ttester");
		assertNotNull("Find by userName on Users illegally returned null",
				result);
		assertTrue("Find by userName on Users failed to return any data",
				result.size() > 0);
		assertEquals(
				"Find by userName on Users returned an incorrect number of entries",
				1, result.size());
	}
	
	@Test
	public void testFindAllByParametersLike() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("lastName", "Do");
		parameters.put("email", "redoair");
		List<User> result = dao.findAllByParametersLike(parameters);
		assertNotNull("Find All By Parameters Like on Users illegally returned null", result);
		assertEquals(
				"Find All By Parameters Like on Users returned an incorrect number of entries",
				2, result.size());
	}
	
	@Test
	public void testFindAllByParametersEqual() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("lastName", "Doe");
		List<User> result = dao.findAllByParametersEqual(parameters);
		assertNotNull("Find All By Parameters Equal on Users illegally returned null", result);
		assertEquals(
				"Find All By Parameters Equal on Users returned an incorrect number of entries",
				2, result.size());
	}
	
	@Test
	public void testFindRangeByParametersLike() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("lastName", "Do");
		List<User> result = dao.findRangeByParametersLike(parameters, 0, 1);
		assertNotNull("Find Range By Parameters Like on Users illegally returned null", result);
		assertEquals(
				"Find Range By Parameters Like on Users returned an incorrect number of entries",
				1, result.size());
	}
	
	@Test
	public void testFindRangeByParametersEqual() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("lastName", "Doe");
		List<User> result = dao.findRangeByParametersEqual(parameters, 0, 1);
		assertNotNull("Find Range By Parameters Equal on Users illegally returned null", result);
		assertEquals(
				"Find Range By Parameters Equal on Users returned an incorrect number of entries",
				1, result.size());
	}

	@Test
	public void testUpdateUser() {
		User user = dao.find(3L);
		user.setFirstName("testUpdateFirstName");
		Long currentVersion = user.getVersion();
		User updated = dao.update(user);
		assertEquals(
				"Identifier of updated User is not the same as identifier of original User",
				updated.getId().longValue(), 3L);
		assertTrue(
				"Version for User failed to increment on update",
				(currentVersion != null && updated.getVersion() > currentVersion));
	}

	@Test
	public void testCreateUser() {
		User user = new User("Sansa", "Stark", "Sansa.Stark@redoair.be",
				"sstark");
		assertNull("Expected User identifier to be null", user.getId());
		dao.create(user);
		assertNotNull("Expected User identifier to no longer be null",
				user.getId());
	}

	@Test
	public void testDeleteUser() {
		User user = dao.find(5L);
		dao.delete(user);
		assertNull("Failed to remove User with identifier '5'", dao.find(5L));
	}
	
	@Test
	public void testDeleteUserById() {
		dao.deleteById(6L);
		assertNull("Failed to remove User with identifier '6'", dao.find(6L));
	}

}
