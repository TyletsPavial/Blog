package com.blog.service.user;


import com.blog.model.User;

import java.util.List;

public interface UserService {
    User findByLogin(String login);
    List<User> findAll();
    User findById(int id);

    void delete(int Id);
}
