package org.test;

import com.vaadin.shared.MouseEventDetails.MouseButton;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public abstract class InformationButton<T> extends Button {

    private static final long serialVersionUID = -713162448881190514L;

    protected T entity;
    private String windowTitle = "";
    private MouseButton mouseButton;

    public InformationButton(MouseButton mouseButton) {
        super();
        this.mouseButton = mouseButton;
        init();
    }

    public InformationButton(MouseButton mouseButton, String caption) {
        super(caption);
        this.mouseButton = mouseButton;
        init();
    }

    protected abstract Component getInformationWindowContent();

    private void init() {

        addStyleName(ValoTheme.BUTTON_QUIET);
        addContextClickListener(event -> {
            if (event != null && event.getButton() == this.mouseButton) {
                Window window = new Window(getWindowTitle());
                window.setModal(true);
                window.setWidth("60%");

                window.setContent(getInformationWindowContent());
                UI.getCurrent().addWindow(window);
            }
        });
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public String getWindowTitle() {
        return windowTitle;
    }

    public void setWindowTitle(String windowTitle) {
        this.windowTitle = windowTitle;
    }

}
