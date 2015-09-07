package be.ticket.observers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;

public class Message implements Serializable {
	private static final long serialVersionUID = -8164841773954943347L;
	private final String component;
	private final String messageKey;
	private final FacesMessage.Severity severity;

	public Message(String component, String messageKey) {
		this(component, messageKey, FacesMessage.SEVERITY_INFO);
	}

	public Message(String component, String messageKey,
			FacesMessage.Severity severity) {
		super();
		this.component = component;
		this.messageKey = messageKey;
		this.severity = severity;
	}

	public String getComponent() {
		return component;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public FacesMessage.Severity getSeverity() {
		return severity;
	}

}
