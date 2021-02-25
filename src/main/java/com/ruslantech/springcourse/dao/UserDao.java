package com.ruslantech.springcourse.dao;

import com.ruslantech.springcourse.models.User;

import java.util.List;

public interface UserDao {
    void createUser(String name, int age, String email);
    List<User> getAllUsers();
    User getUser(int id);
    void editUser(User user);
    void deleteUser(int id);
}
