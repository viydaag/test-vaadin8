package org.test;

import com.vaadin.ui.Grid;

public class SkillView extends AbstractCrudView<Skill> {

	private static final long serialVersionUID = -7630758272011003929L;

    @Override
    public DSAbstractForm<Skill> getForm() {
        return new SkillForm();
    }

    @Override
    public Grid<Skill> getGrid() {
        return new SkillGrid();
    }

    @Override
    public DataService<Skill, Long> getDataService() {
        return SkillService.getInstance();
    }


}
