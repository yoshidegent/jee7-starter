package be.ticket.component;

import javax.el.MethodExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 * Workaround for the Mojarra error: wrong number of arguments. Happens when
 * adding an Ajax listener to a custom composite component.
 */

@FacesComponent(value = "ajaxListenerComponent")
public class AjaxListenerComponent extends UIComponentBase implements
		NamingContainer {

	@Override
	public String getFamily() {
		return "javax.faces.NamingContainer";
	}

	public void ajaxEventListener(AjaxBehaviorEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		MethodExpression ajaxEventListener = (MethodExpression) getAttributes()
				.get("listener");
		if (ajaxEventListener != null) {
			ajaxEventListener.invoke(context.getELContext(),
					new Object[] { event });
		}
	}

}
