package org.test;

import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.v7.fields.MTextArea;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;

public class SkillForm extends DSAbstractForm<Skill> {

    private static final long serialVersionUID = -4123881637907722632L;

    private MTextField           name;
    private MTextField           shortDescription;
    private MTextArea            description;
    private ComboBox<Ability> keyAbility;

    private DataService<Ability, Long> abilityService = AbilityService.getInstance();

    public SkillForm() {
        super(Skill.class);
    }

    @Override
    public String toString() {
        return "Compétence";
    }

    @Override
    protected Component createContent() {
        FormLayout layout = new FormLayout();

        name = new MTextField("Nom");
        shortDescription = new MTextField("Description courte").withFullWidth();
        description = new MTextArea("Description").withFullWidth();
        keyAbility = new ComboBox<Ability>("Attribut clé", abilityService.findAll());
        keyAbility.setItemCaptionGenerator(option -> option.getName());
        //        keyAbility.setCaptionGenerator(new CaptionGenerator<Ability>() {
        //
        //            private static final long serialVersionUID = -3188362153311215227L;
        //
        //            @Override
        //            public String getCaption(Ability option) {
        //                return option.getName();
        //            }
        //        });

        layout.addComponent(name);
        layout.addComponent(shortDescription);
        layout.addComponent(description);
        layout.addComponent(keyAbility);
        layout.addComponent(getToolbar());

        return layout;
    }
}
