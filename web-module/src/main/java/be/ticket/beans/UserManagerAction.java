package be.ticket.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import be.ticket.entity.User;
import be.ticket.error.InvalidUserException;
import be.ticket.observers.Message;
import be.ticket.session.UserService;

@Named
@RequestScoped
public class UserManagerAction {

	@Inject
	private Conversation conversation;

	@Inject
	private UserBean userBean;

	@Inject
	UserService userService;

	@Inject
	Event<Message> event;

	private DataModel<User> users;

	@PostConstruct
	public void init() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
		reload();
	}

	public String createUser() {
		try {
			userService.createUser(userBean.getUser());
			event.fire(new Message(null, "be.ticket.entity.user.created"));
			reload();
			return "userlist?faces-redirect=true";
		} catch (InvalidUserException e) {
			event.fire(new Message(null, "be.ticket.entity.user.exists",
					FacesMessage.SEVERITY_ERROR));
			return null;
		}
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public String editUser() {
		User user = users.getRowData();
		userBean.setUser(user);
		return "usercreate";
	}

	public String updateUser() {
		userService.updateUser(userBean.getUser());
		event.fire(new Message(null, "be.ticket.entity.user.updated"));
		reload();
		if (!conversation.isTransient()) {
			conversation.end();
		}
		return "userlist?faces-redirect=true";
	}

	public String cancel() {
		event.fire(new Message(null, "be.ticket.entity.user.update.canceled",
				FacesMessage.SEVERITY_WARN));
		reload();
		if (!conversation.isTransient()) {
			conversation.end();
		}
		return "userlist?faces-redirect=true";
	}

	public void deleteUser(AjaxBehaviorEvent abe) {
		User user = users.getRowData();
		userService.deleteUser(user);
		event.fire(new Message(null, "be.ticket.entity.user.deleted"));
		reload();
	}

	public DataModel<User> getUsers() {
		return users;
	}

	public boolean isUsersEmpty() {
		return users != null ? users.getRowCount() == 0 : true;
	}

	public void validateUserName(AjaxBehaviorEvent abe) {
		if (!userService.validUserName(userBean.getUser().getUserName())) {
			event.fire(new Message(abe.getComponent().getClientId(),
					"be.ticket.entity.user.exists"));
		}
	}

	private void reload() {
		users = new ListDataModel<User>();
		users.setWrappedData(userService.findAllUsers());
	}

}
