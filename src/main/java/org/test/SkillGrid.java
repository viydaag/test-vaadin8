package org.test;

import com.vaadin.ui.Grid;

public class SkillGrid extends Grid<Skill> {

    private static final long serialVersionUID = 5108019895920968099L;

    public SkillGrid() {
        super();
        setSizeFull();
        
        addColumn(Skill::getName).setCaption("Nom").setId("name");
        addColumn(Skill::getKeyAbility).setCaption("Caractéristique clé").setId("keyAbility");
    }

}
