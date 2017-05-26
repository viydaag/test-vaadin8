package org.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.test.MultiComponentPojo.EnumTypeField;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Button.ClickEvent;
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

    @Override
    public void addNew(ClickEvent e) {
        Region create = service.create();
        MultiComponentPojo pojo = new MultiComponentPojo();
        pojo.setEnumField(EnumTypeField.TEST1);
        MultiComponentPojo pojo2 = new MultiComponentPojo();
        pojo2.setName("test2");
        create.setPojos(new ArrayList<>(Arrays.asList(pojo, pojo2)));
        form.setEntity(create);
        if (isFormPopup()) {
            form.openInModalPopup();
        }
        form.focusFirst();
    }

    @Override
    public void entrySaved(Region entity) {
        if (entity.getPojos() != null) {
            List<MultiComponentPojo> pojos = new ArrayList<MultiComponentPojo>(entity.getPojos());
            pojos.stream().forEach(feat -> feat.setRegion(entity));
            entity.setPojos(pojos);
        }
        super.entrySaved(entity);
    }

}
