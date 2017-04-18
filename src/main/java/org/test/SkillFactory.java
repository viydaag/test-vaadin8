package org.test;

public class SkillFactory implements Factory<Skill> {

    private static final long serialVersionUID = 5557817143180738685L;

    @Override
    public Skill create() {
        return new Skill();
    }

}
