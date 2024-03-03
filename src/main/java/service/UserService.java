package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    void removeById(long id);
}
