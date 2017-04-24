package org.test;

public class LanguageService extends AbstractDataService<Language, Long> implements DataService<Language, Long> {

    private static final long serialVersionUID = -8778708705346635028L;
    
    private static LanguageService instance = null;

    private LanguageRepository repo = new LanguageRepository();

    public static synchronized LanguageService getInstance() {
        if (instance == null) {
            instance = new LanguageService();
        }
        return instance;
    }

    private LanguageService() {
        super();
        setEntityFactory(() -> new Language());
        setRepository(repo);
    }

}
