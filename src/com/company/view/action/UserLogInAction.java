package com.company.view.action;

import com.company.model.User;
import com.company.view.console.Input;

public class UserLogInAction extends BaseAction implements Action {
    @Override
    public String getName() {
        return "Войти в свой аккаунт.";
    }

    @Override
    public void execute() {
        String username = Input.getString("Введите ваш Логин:");
        String password = Input.getString("Введите ваш пароль:");
        User user = new User(username, password);
        userController.addUser(user);
    }
}
