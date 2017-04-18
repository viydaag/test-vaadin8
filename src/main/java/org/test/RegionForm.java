package org.test;


import com.vaadin.shared.MouseEventDetails.MouseButton;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class RegionForm extends DSAbstractForm<Region> {

    private static final long serialVersionUID = 1416085344583485158L;

    private TextField name;
    private TextArea  description;
    RegionButton      button;

    public RegionForm() {
        super(Region.class);
    }

    @Override
    public String toString() {
        return "Regions";
    }

    @Override
    protected Component createContent() {
        FormLayout layout = new FormLayout();

        button = new RegionButton(MouseButton.LEFT);
        name = new TextField("Nom");
        description = new TextArea("Description");
        description.setRows(10);
        description.setWidth(100, Unit.PERCENTAGE);

        layout.addComponent(button);
        layout.addComponent(name);
        layout.addComponent(description);
        layout.addComponent(getToolbar());

        return layout;
    }

    @Override
    public void afterSetEntity() {
        super.afterSetEntity();
        if (getEntity() != null) {
            button.setWindowTitle(getEntity().getName());
            button.setCaption(getEntity().getName());
            button.setEntity(getEntity());
        }
    }
}
