package org.test;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class SubSetSelectorView extends VerticalLayout implements View {

    private static final long serialVersionUID = 153591559823003292L;

    public SubSetSelectorView() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void enter(ViewChangeEvent event) {
        SubSetSelectorDraggable<Region, List<Region>> selector = new SubSetSelectorDraggable<>();
        selector.setWidth("50%");
        selector.setDescriptionGenerator(Region::getDescription);
        //        selector.setDraggableStyle(ValoTheme.BUTTON_FRIENDLY);
        //        selector.setLimit(2);
        selector.setItems(RegionService.getInstance().findAll());
        selector.setValue(new ArrayList<>());
        selector.setCaption("Sélection");
        addComponent(selector);

    }

}
