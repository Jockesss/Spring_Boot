package web.service;


import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersList();

    void addUser(User user);

    User getUserById(Long id);

    void updateUser(User updateUser);

    void deleteUser(Long id);
}
