package org.test;


public class AccessRoleRepository extends AbstractRepository<AccessRole, Long> {

    private static final long serialVersionUID = -4451030772782301270L;

    @Override
    protected Class<AccessRole> getEntityClass() {
        return AccessRole.class;
    }

}
