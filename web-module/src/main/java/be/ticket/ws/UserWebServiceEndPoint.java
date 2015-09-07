package be.ticket.ws;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import be.ticket.entity.User;
import be.ticket.session.UserService;

@WebService(serviceName = "UserWebService") 
@Stateless
public class UserWebServiceEndPoint implements UserWebService {
	@Inject
	private UserService userService;
	
	@WebMethod
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}
}
