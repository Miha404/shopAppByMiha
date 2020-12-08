package com.company.view.action;

import com.company.exception.DuplicateUserException;
import com.company.model.User;
import com.company.view.console.Input;

import java.util.zip.DataFormatException;

public class CreateNewUserAccount extends BaseAction implements Action {
    @Override
    public String getName() {
        return "Создать нового пользователя.";
    }

    @Override
    public void execute()  {
        String name = Input.getString("Введите свой Логин");
        String password = Input.getString("Введите пароль");
        User user = new User(name, password);
        try {
            userController.createUser(user);
        } catch (DuplicateUserException exception){
            System.out.println(exception.getMessage());
        }

    }
}
