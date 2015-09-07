package be.ticket.error;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class UnhandledExceptionExceptionHandlerFactory extends
		ExceptionHandlerFactory {

	private ExceptionHandlerFactory parent;

	public UnhandledExceptionExceptionHandlerFactory(
			ExceptionHandlerFactory parent) {
		this.parent = parent;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		ExceptionHandler result = parent.getExceptionHandler();
		result = new UnhandledExceptionExceptionHandler(result);
		return result;
	}

}
