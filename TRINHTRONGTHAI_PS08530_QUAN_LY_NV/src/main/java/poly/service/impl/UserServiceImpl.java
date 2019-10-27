package poly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dao.UserDao;
import poly.dao.impl.HibernateHelper;
import poly.model.User;
import poly.service.UserService;

@Service
public class UserServiceImpl extends HibernateHelper implements UserService{
@Autowired
UserDao userDao;
	@Override
	public User findByName(String username) {
		
		return userDao.findByUser(username);
	}
	@Override
	public boolean updateUser(User user) {
		
		return userDao.updateUser(user);
	}

}
