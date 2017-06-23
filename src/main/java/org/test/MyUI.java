package org.test;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    private static final long serialVersionUID = -8908616934031237847L;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        VerticalLayout viewlayout = new VerticalLayout();
        viewlayout.setMargin(false);
        Navigator navigator = new Navigator(this, viewlayout);

        HorizontalLayout buttonLayout = new HorizontalLayout();
        Button button = new Button("Region");
        button.addClickListener( e -> {
            navigator.navigateTo("region");
        });

        Button button2 = new Button("Skill");
        button2.addClickListener(e -> {
            navigator.navigateTo("skill");
        });
        
        Button button3 = new Button("Level");
        button3.addClickListener(e -> {
            navigator.navigateTo("level");
        });

        Button button4 = new Button("Language");
        button4.addClickListener(e -> {
            navigator.navigateTo("language");
        });

        Button button5 = new Button("User");
        button5.addClickListener(e -> {
            navigator.navigateTo("user");
        });

        Button button6 = new Button("Selector");
        button6.addClickListener(e -> {
            navigator.navigateTo("selector");
        });

        buttonLayout.addComponents(button, button2, button3, button4, button5, button6);

        navigator.addView("region", RegionView.class);
        navigator.addView("skill", SkillView.class);
        navigator.addView("level", LevelView.class);
        navigator.addView("language", LanguageView.class);
        navigator.addView("user", UserListView.class);
        navigator.addView("selector", SubSetSelectorView.class);

        layout.addComponents(buttonLayout);
        //        layout.addComponent(new PojoForm());
        layout.addComponentsAndExpand(viewlayout);
        
        setContent(layout);

        Responsive.makeResponsive(this);

        navigator.navigateTo("region");
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

        private static final long serialVersionUID = 4761276553072766217L;
    }
}
