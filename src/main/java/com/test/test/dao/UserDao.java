package com.test.test.dao;

import com.test.test.models.User;

import java.util.List;

public interface UserDao{
    List<User> getUsers();

    void delete(Long id);

    void register(User user);

    User getUserByCredentials(User user);
}
