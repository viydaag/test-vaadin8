package org.test;

import com.vaadin.ui.Grid;

public class RegionGrid extends Grid<Region> {

    private static final long serialVersionUID = 4099520204353044818L;

    public RegionGrid() {
        super();
        setSelectionMode(SelectionMode.SINGLE);
        setSizeFull();

        addColumn(Region::getName).setCaption("Nom").setSortProperty("name").setId("name");
    }

}
