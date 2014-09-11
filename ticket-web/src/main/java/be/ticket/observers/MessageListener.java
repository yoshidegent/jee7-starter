package be.ticket.observers;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.event.Observes;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageListener {
	
	public void addMessage(@Observes Message message) {
		String messageText = getMessageText(message.getMessageKey());
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(message.getSeverity(), messageText, messageText);
		facesContext.getExternalContext().getFlash().setKeepMessages(true);
		facesContext.addMessage(message.getComponent(), facesMessage);
	}
	
	private String getMessageText(String key) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String messageBundleName = facesContext.getApplication().getMessageBundle();
		Locale locale = facesContext.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, locale);
		return bundle.getString(key);
	}
}
