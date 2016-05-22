package dao;


import entity.User;

import java.util.List;

public interface UserRepository {

    void createUser(User user);

    User getUser(Integer id);

    List<User> getUsers();

    void updateUser(User user);

    void deleteUser(Integer id);
}
