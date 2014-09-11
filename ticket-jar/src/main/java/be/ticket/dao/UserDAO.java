package be.ticket.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;

import be.ticket.entity.User;

@Stateless
@LocalBean
@Named
public class UserDAO extends AbstractDAO<User> {
	public List<User> findUsersByUserName(String userName) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userName", userName);
		return findByNamedQuery(User.FIND_USERS_BY_USERNAME, parameters);
	}
}
