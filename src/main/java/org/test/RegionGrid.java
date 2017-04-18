package org.test;

import com.vaadin.ui.Grid;

public class RegionGrid extends Grid<Region> {

    private static final long serialVersionUID = 4099520204353044818L;

    public RegionGrid() {
        super(Region.class);
        setSelectionMode(SelectionMode.SINGLE);
        setSizeFull();

        removeAllColumns();
        addColumn("name").setCaption("Nom").setSortProperty("name");
    }

}
