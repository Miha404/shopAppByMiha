package com.company.dao;

import com.company.exception.DuplicateUserException;
import com.company.model.User;
import com.company.view.console.StartApplication;

import java.util.ArrayList;
import java.util.List;

public class UserDaoMemory implements UserDao {
    private static List<User> userList;

    private static List<User> getUserList() {
        if (userList == null) {
            userList = new ArrayList<>();
            userList.add(new User("Admin", "admin"));
        }
        return userList;
    }

    @Override
    public void createNewUser(User user) throws DuplicateUserException {
        int index = getUserIndex(user.getUsername());
        if (index != -1) {
            throw new DuplicateUserException(user.getUsername());
        }
        getUserList().add(user);
    }

    @Override
    public boolean logInUser(User user) {

        int index = getUserIndex(user.getUsername());
        if (index != -1) {
            boolean compareLogin = user.getUsername().equals(getUserList().get(index).getUsername());
            boolean comparePassword = user.getPassword().equals(getUserList().get(index).getPassword());
            if (compareLogin) {
                StartApplication.enterAccess = comparePassword(getUserList().get(index), comparePassword);
                return StartApplication.enterAccess;
            }
        } else {
            System.out.println("Такого пользователя не существует! Попробуйте еще раз.");
        }
        return false;
    }

    private int getUserIndex(String name) {
        int index;
        for (int i = 0; i < getUserList().size(); i++) {
            if (name.equals(getUserList().get(i).getUsername())) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    private static boolean comparePassword(User user, boolean comparePassword) {
        boolean userAccess = false;
        if (comparePassword) {
            accessIsAllowed(user);
            userAccess = true;
        } else {
            wrongAccess(user);
        }
        return userAccess;

    }

    private static void wrongAccess(User user) {
        user.setLogInTry(user.getLogInTry() - 1);
        if (user.getLogInTry() > 0 && !user.isUserBan()) {
            System.out.printf("Неверный пароль или логин. Пожалуйста попробуйте еще раз. " +
                    "Попыток: %s", user.getLogInTry());
            System.out.println();
        } else {
            banUser(user);
        }
    }

    private static void banUser(User user) {
        user.setUserBan(true);
        System.out.println("Пользователь заблокирован. Обратитесь в техподдержку.");
    }

    private static void accessIsAllowed(User user) {
        user.setLogInTry(3);
        System.out.println("Добро пожаловать в наш магазтин.");
    }


}
