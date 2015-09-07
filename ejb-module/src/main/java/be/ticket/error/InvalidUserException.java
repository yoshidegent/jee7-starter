package be.ticket.error;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class InvalidUserException extends Exception {

	private static final long serialVersionUID = 4909384598261554404L;

	public InvalidUserException() {
	}

	public InvalidUserException(String message) {
		super(message);
		}

	public InvalidUserException(Throwable cause) {
		super(cause);
	}

	public InvalidUserException(String message, Throwable cause) {
		super(message, cause);
	}

}
