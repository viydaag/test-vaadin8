package org.test;

import org.test.MultiComponentPojo.EnumTypeField;
import org.vaadin.viritin.fields.IntegerField;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;

public class MultiComponentPojoGrid extends Grid<MultiComponentPojo> {

    private static final long serialVersionUID = -9173769124643306993L;

    public MultiComponentPojoGrid() {
        super();
        setSelectionMode(SelectionMode.SINGLE);
        setWidth(100, Unit.PERCENTAGE);
        setHeightUndefined();

        addComponentColumn(entity -> {
            TextField name = new TextField();
            return name;
        });
        addComponentColumn(entity -> {
            IntegerField integerField = new IntegerField();
            return integerField;
        });
        addComponentColumn(entity -> {
            DoubleField field = new DoubleField();
            return field;
        });
        addComponentColumn(entity -> {
            CheckBox field = new CheckBox();
            return field;
        });
        addComponentColumn(entity -> {
            DateField field = new DateField();
            return field;
        });
        addComponentColumn(entity -> {
            EnumComboBox<EnumTypeField> field = new EnumComboBox<>(EnumTypeField.class);
            return field;
        });
        setRowHeight(40);
    }

}
