package com.company.view.console;

import com.company.config.ConsoleConfig;
import com.company.controller.UserController;
import com.company.dao.UserDaoMemory;
import com.company.exception.DuplicateUserException;
import com.company.view.action.Action;
import com.company.view.action.UserLogInAction;

import java.util.Map;

public class StartApplication implements ApplicationWork {
    public static boolean go = true;
    public static boolean enterAccess = false;
    public void start() throws DuplicateUserException {
        System.out.println("Добро пожаловать в мое первое консольное приложение!");
        run();
    }

    @Override
    public void run() throws DuplicateUserException {
        System.out.println("Для начала Вам нужно зарегистрироваться или зайти в свой аккаунт.");
        while (go && !enterAccess) {
            Action action = getAction();
            action.execute();
        }

    }

    private Action getAction() {
        showMenu();
        int number = Input.getInt("Выберите номер действия");
        Action action = ConsoleConfig.userActionMap.get(number);
        if (action != null) {
            return action;
        }
        System.out.println("Нет такого действия");
        return getAction();
    }

    @Override
    public void showMenu() {
        for (Map.Entry<Integer, Action> oneActionEntry : ConsoleConfig.userActionMap.entrySet()) {
            System.out.printf("%s - %s\n", oneActionEntry.getKey(), oneActionEntry.getValue().getName());
        }
    }
}
