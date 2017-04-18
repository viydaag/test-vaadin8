package org.test;

import com.vaadin.ui.Grid;

public class SkillGrid extends Grid<Skill> {

    private static final long serialVersionUID = 5108019895920968099L;

    public SkillGrid() {
        super(Skill.class);
        setSizeFull();
        //        withProperties("name", "keyAbility.name", "shortDescription");
        //        withColumnHeaders("Nom", "Caractéristique clé", "Description courte");

        removeAllColumns();
        addColumn(Skill::getName);
        addColumn(Skill::getKeyAbility);
    }

}
