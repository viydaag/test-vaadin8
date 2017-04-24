package org.test;



public interface UserDataService extends DataService<User, Long> {

    public User findByUsername(String username);
	
}
