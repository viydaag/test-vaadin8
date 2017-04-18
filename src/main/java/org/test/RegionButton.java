package org.test;

import com.vaadin.shared.MouseEventDetails.MouseButton;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;

public class RegionButton extends InformationButton<Region> {

    public RegionButton(MouseButton mouseButton) {
        super(mouseButton);
    }

    private static final long serialVersionUID = -3296920450613095687L;

    @Override
    protected Component getInformationWindowContent() {
        return new Label(entity.getDescription());
    }

}
