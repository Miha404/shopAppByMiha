package com.company.controller;

import com.company.dao.UserDao;
import com.company.dao.UserDaoMemory;
import com.company.exception.DuplicateUserException;
import com.company.model.User;

public class UserController {
    private UserDao userDao = new UserDaoMemory();

    public UserDao getUserDao() {
        return userDao;
    }
    public void addUser(User user){
        userDao.logInUser(user);
    }
    public void createUser(User user) throws DuplicateUserException {
        userDao.createNewUser(user);
    }
}
