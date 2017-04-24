package org.test;

import org.vaadin.viritin.fields.IntegerField;

import com.vaadin.ui.Grid;

public class LevelGrid extends Grid<Level> {

    private static final long serialVersionUID = -2219582474895040784L;

    public LevelGrid() {
        super();
        setSelectionMode(SelectionMode.SINGLE);
        setSizeFull();

        getEditor().setEnabled(true);

        addColumn(Level::getId).setCaption("Niveau");
        addColumn(Level::getProficiencyBonus).setCaption("Bonus de maitrise").setEditorComponent(new IntegerField(), Level::setProficiencyBonus);
        addColumn(Level::getMaxExperience).setCaption("Plafond d'expérience").setEditorComponent(new LongField(), Level::setMaxExperience);

    }

}
