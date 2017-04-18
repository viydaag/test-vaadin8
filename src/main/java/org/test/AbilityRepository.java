package org.test;

public class AbilityRepository extends AbstractRepository<Ability, Long> {

    private static final long serialVersionUID = -1785503539532635011L;

    @Override
    protected Class<Ability> getEntityClass() {
        return Ability.class;
    }

}
