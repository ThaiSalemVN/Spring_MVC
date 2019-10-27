package poly.service;

import poly.model.User;

public interface UserService {
	User findByName(String username);
	boolean updateUser(User user);
}
