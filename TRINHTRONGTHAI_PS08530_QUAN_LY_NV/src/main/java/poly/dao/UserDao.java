package poly.dao;

import poly.model.User;

public interface UserDao {
	User findByUser(String name);
	boolean updateUser(User user);
}
