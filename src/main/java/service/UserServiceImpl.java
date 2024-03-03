package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserDao userDao;
    @Autowired
    UserServiceImpl(@Qualifier("userDaoImpl") UserDao dao) {
        this.userDao = dao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void save(User user) {
        userDao.save(user);

    }

    @Override
    public void removeById(long id) {
        userDao.removeById(id);
    }
}
