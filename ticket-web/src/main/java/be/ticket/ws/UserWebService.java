package be.ticket.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import be.ticket.entity.User;

@WebService
public interface UserWebService {
	@WebMethod
	List<User> findAllUsers();
}
