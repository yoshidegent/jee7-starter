package be.ticket.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import be.ticket.session.UserService;

@Path("/users")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class UserRESTServiceEndPoint implements UserRESTService {

	@Inject
	private UserService userService;
	
	@GET  
	public UserListWrapper findAllUsers() {
		return new UserListWrapper(userService.findAllUsers());
	}
	
}
