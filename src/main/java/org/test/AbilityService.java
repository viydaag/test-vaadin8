package org.test;

public class AbilityService extends AbstractDataService<Ability, Long> {

    private static final long serialVersionUID = 6468595169787824606L;

    private static AbilityService instance = null;

    public static synchronized AbilityService getInstance() {
        if (instance == null) {
            instance = new AbilityService();
        }
        return instance;
    }

    private AbilityService() {
        super();
        setEntityFactory(new AbilityFactory());
        setRepository(new AbilityRepository());
    }

}
