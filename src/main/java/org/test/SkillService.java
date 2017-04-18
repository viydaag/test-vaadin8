package org.test;

public class SkillService extends AbstractDataService<Skill, Long> {

	private static final long serialVersionUID = -5037432994965855361L;
	
	private static SkillService instance = null;

    public static synchronized SkillService getInstance() {
        if (instance == null) {
            instance = new SkillService();
        }
        return instance;
    }

    private SkillService() {
        super();
        setEntityFactory(new SkillFactory());
        setRepository(new SkillRepository());
    }

}
