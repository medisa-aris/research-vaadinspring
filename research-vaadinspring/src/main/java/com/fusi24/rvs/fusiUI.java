package com.fusi24.rvs;

import javax.servlet.annotation.WebServlet;

import com.fusi24.rvs.generated.LoginForm;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("fusiTheme")
public class fusiUI extends UI {
	
	private LoginForm loginForm = new LoginForm();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setWidth("100%");
        layout.setHeight("100%");

        layout.addComponents(loginForm); 
        layout.setComponentAlignment(loginForm,Alignment.MIDDLE_CENTER);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "fusiUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = fusiUI.class, productionMode = false)
    public static class fusiUIServlet extends VaadinServlet {
    }
}
