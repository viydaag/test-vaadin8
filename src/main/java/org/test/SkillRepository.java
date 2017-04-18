package org.test;

public class SkillRepository extends AbstractRepository<Skill, Long> {

    private static final long serialVersionUID = -582349526865630337L;

    @Override
    protected Class<Skill> getEntityClass() {
        return Skill.class;
    }

}
