package org.test;

import com.vaadin.ui.Grid;

public class LanguageView extends AbstractCrudView<Language> {

    private static final long serialVersionUID = -1727374101226087197L;

    public LanguageView() {
        super();
    }

    @Override
    public DSAbstractForm<Language> getForm() {
        return new LanguageForm();
    }

    @Override
    public Grid<Language> getGrid() {
        return new LanguageGrid();
    }

    @Override
    public DataService<Language, Long> getDataService() {
        return LanguageService.getInstance();
    }

}
