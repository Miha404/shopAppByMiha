package com.company.dao;

import com.company.exception.DuplicateUserException;
import com.company.model.User;

public interface UserDao {
    void createNewUser(User user) throws DuplicateUserException;
    boolean logInUser(User user);
}
