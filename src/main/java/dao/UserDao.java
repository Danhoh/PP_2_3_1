package dao;

import model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void save(User user);

    void removeById(long id);

}
