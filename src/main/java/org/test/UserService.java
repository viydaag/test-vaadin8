package org.test;

import org.apache.commons.codec.digest.DigestUtils;


public class UserService extends AbstractDataService<User, Long> implements UserDataService {

	private static final long serialVersionUID = 2368180652957632605L;
	
	private static UserService instance = null;

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {
        super();
        setEntityFactory(() -> new User());
        setRepository(new UserRepository());
    }

    @Override
    public User findByUsername(String username) {
        return ((UserRepository) entityRepository).findByUsername(username);
    }

    @Override
    public void create(User entity) {
        entity.setPassword(DigestUtils.md5Hex(entity.getPassword()));
        super.create(entity);
    }

}
