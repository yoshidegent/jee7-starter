package be.ticket.beans;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import be.ticket.entity.User;

@Named
@ConversationScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean isManaged() {
		return user.getId() != null;		
	}
	
}
