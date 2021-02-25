package com.ruslantech.springcourse.dao;

import com.ruslantech.springcourse.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createUser(String name, int age, String email) {
        User user = new User(name, age, email);
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> listUsers = (List<User>) entityManager.createQuery("from User").getResultList();
        return listUsers;
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
