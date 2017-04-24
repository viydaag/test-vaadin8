package org.test;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserRepository extends AbstractRepository<User, Long> {

    private static final long serialVersionUID = 2373570896727026456L;

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    public User findByUsername(String username) {
        if (username == null) {
            return null;
        }
        TypedQuery<User> query = entityManager.createNamedQuery(User.findByUsername, User.class);
        query = query.setParameter("username", username);
        User user;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }
        return user;
    }

}
