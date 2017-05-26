package org.test;

import org.test.MultiComponentPojo.EnumTypeField;
import org.vaadin.viritin.fields.IntegerField;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class RegionForm extends DSAbstractForm<Region> {

    private static final long serialVersionUID = 1416085344583485158L;

    private TextField                                 name;
    private TextArea                                  description;
    private ElementCollectionGrid<MultiComponentPojo> pojos;
    //    private MultiComponentPojoGrid                    grid;
    //    private ListDataProvider<MultiComponentPojo>      pojoDataProvider;
    //    private ArrayList<MultiComponentPojo>             pojoList;
    //    RegionButton      button;

    public static class MultiComponentPojoRow {
        public TextField                   name         = new TextField();
        public IntegerField                integerField = new IntegerField();
        public DoubleField                 doubleField  = new DoubleField();
        public CheckBox                    booleanField = new CheckBox();
        public DateField                   dateField    = new DateField();
        public EnumComboBox<EnumTypeField> enumField    = new EnumComboBox<>(EnumTypeField.class);
        public ComboBox<Ability>           objectField  = new ComboBox<Ability>();
    }

    public RegionForm() {
        super(Region.class);
        //        grid = new MultiComponentPojoGrid();
        //        pojoList = new ArrayList<MultiComponentPojo>();
        //        pojoDataProvider = DataProvider.ofCollection(pojoList);
        //        grid.setDataProvider(pojoDataProvider);
        //        grid.setItems(pojoList);
    }

    @Override
    public String toString() {
        return "Regions";
    }

    @Override
    protected Component createContent() {
        FormLayout layout = new FormLayout();

        //        button = new RegionButton(MouseButton.LEFT);
        name = new TextField("Nom");
        description = new TextArea("Description");
        description.setRows(10);
        description.setWidth(100, Unit.PERCENTAGE);

        pojos = new ElementCollectionGrid<MultiComponentPojo>(MultiComponentPojo.class, MultiComponentPojoRow.class).withCaption("Pojos")
                .withEditorInstantiator(() -> {
                    MultiComponentPojoRow row = new MultiComponentPojoRow();
                    row.objectField.setItems(AbilityService.getInstance().findAll());
                    //                    row.objectField.setWidth(100, Unit.PERCENTAGE);
                    return row;
                });
        pojos.setPropertyHeader("name", "String");
        pojos.setPropertyHeader("integerField", "Integer");
        pojos.setPropertyHeader("doubleField", "Double");
        pojos.setPropertyHeader("booleanField", "CheckBox");
        pojos.setPropertyHeader("dateField", "Date");
        pojos.setPropertyHeader("enumField", "Enum");
        pojos.setPropertyHeader("objectField", "Object");
        pojos.setWidth("90%");

        //        layout.addComponent(button);
        layout.addComponent(name);
        layout.addComponent(description);
        layout.addComponent(pojos);

        //        Button addPojoButton = new Button("add line");
        //        addPojoButton.addClickListener(click -> {
        //            pojoList.add(new MultiComponentPojo());
        //            //            grid.setItems(pojoList);
        //            pojoDataProvider.refreshAll();
        //        });

        //        layout.addComponent(grid);
        //        layout.addComponent(addPojoButton);

        layout.addComponent(getToolbar());

        return layout;
    }

    //    @Override
    //    public void afterSetEntity() {
    //        super.afterSetEntity();
    //        if (getEntity() != null) {
    //            button.setWindowTitle(getEntity().getName());
    //            button.setCaption(getEntity().getName());
    //            button.setEntity(getEntity());
    //        }
    //    }
}
