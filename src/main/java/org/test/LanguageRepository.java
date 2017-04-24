package org.test;

public class LanguageRepository extends AbstractRepository<Language, Long> {

    private static final long serialVersionUID = -6827271738126173159L;

    @Override
    protected Class<Language> getEntityClass() {
        return Language.class;
    }
}
