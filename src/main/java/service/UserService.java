package service;

import model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    void save(User user);

    void removeById(long id);
}
