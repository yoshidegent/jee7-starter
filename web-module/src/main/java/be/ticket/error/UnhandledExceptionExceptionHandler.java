package be.ticket.error;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class UnhandledExceptionExceptionHandler extends
		ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;

	public UnhandledExceptionExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return wrapped;
	}

	@Override
	public void handle() throws FacesException {
		for (Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents()
				.iterator(); i.hasNext();) {
			ExceptionQueuedEvent event = i.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event
					.getSource();
			Throwable t = context.getException();

			FacesContext fc = FacesContext.getCurrentInstance();
			Map<String, Object> requestMap = fc.getExternalContext()
					.getRequestMap();
			NavigationHandler nav = fc.getApplication().getNavigationHandler();
			String message = t.getClass().getCanonicalName();

			try {
				if (t instanceof ViewExpiredException) {
					ViewExpiredException vee = (ViewExpiredException) t;
					message = message + " at " + vee.getViewId();
				}
				requestMap.put("message", message);
				nav.handleNavigation(fc, null, "error");
				fc.renderResponse();
			} finally {
				i.remove();
			}

		}

		getWrapped().handle();

	}
}
