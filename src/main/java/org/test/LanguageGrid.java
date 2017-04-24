package org.test;

import com.vaadin.data.ValueContext;
import com.vaadin.data.converter.StringToBooleanConverter;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.HtmlRenderer;

public class LanguageGrid extends Grid<Language> {

    private static final long serialVersionUID = -8818716671121858460L;

    public LanguageGrid() {
        super();
        //        withProperties("name", "script", "playable");
        //        withColumnHeaders("Nom", "Alphabet", "Jouable");
        //
        //        Grid.Column playable = getColumn("playable");
        //        playable.setRenderer(new HtmlRenderer(),
        //                new StringToBooleanConverter(FontAwesome.CHECK_CIRCLE_O.getHtml(), FontAwesome.CIRCLE_O.getHtml()));

        StringToBooleanConverter converter = new StringToBooleanConverter("", VaadinIcons.CHECK_CIRCLE_O.getHtml(),
                VaadinIcons.CIRCLE_THIN.getHtml());
        addColumn(Language::getName).setCaption("Nom");
        addColumn(language -> converter.convertToPresentation(language.getPlayable(), new ValueContext()), new HtmlRenderer()).setCaption("Jouable");
    }

}
