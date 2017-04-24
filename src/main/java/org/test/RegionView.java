package org.test;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Grid;

public class RegionView extends AbstractCrudView<Region> {

    private static final long serialVersionUID = 5117755861151432771L;

    public RegionView() {
        super();
    }

    @Override
    public DSAbstractForm<Region> getForm() {
        return new RegionForm();
    }

    @Override
    public Grid<Region> getGrid() {
        return new RegionGrid();
    }

    @Override
    public DataService<Region, Long> getDataService() {
        return RegionService.getInstance();
    }

    @Override
    public void enter(ViewChangeEvent event) {
        super.enter(event);
        grid.sort(grid.getColumn("name"), SortDirection.ASCENDING);

    }

}
