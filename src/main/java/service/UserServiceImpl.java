package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDao;
    @Autowired
    UserServiceImpl(@Qualifier("userDaoImpl") UserDao dao) {
        this.userDao = dao;
    }
}
