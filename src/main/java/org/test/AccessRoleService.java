package org.test;


public class AccessRoleService extends AbstractDataService<AccessRole, Long> {

    private static final long serialVersionUID = 6468595169787824606L;

    private static AccessRoleService instance = null;

    public static synchronized AccessRoleService getInstance() {
        if (instance == null) {
            instance = new AccessRoleService();
        }
        return instance;
    }

    private AccessRoleService() {
        super();
        setEntityFactory(() -> new AccessRole());
        setRepository(new AccessRoleRepository());
    }

}
