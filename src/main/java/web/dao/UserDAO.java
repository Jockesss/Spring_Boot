package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsersList();

    void addUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}
