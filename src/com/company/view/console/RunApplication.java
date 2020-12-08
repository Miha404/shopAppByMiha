package com.company.view.console;

import com.company.config.ConsoleConfig;
import com.company.exception.DuplicateUserException;
import com.company.view.action.Action;
import com.company.view.action.UserLogInAction;

import java.util.Map;


public class RunApplication implements ApplicationWork {


    public void applicationRun() throws DuplicateUserException {
        run();
    }

    @Override
    public void run() throws DuplicateUserException {
        while (StartApplication.go) {
            Action action = getAction();
            action.execute();
        }
    }

    private Action getAction() {
        showMenu();
        int number = Input.getInt("Выберите номер действия");
        Action action = ConsoleConfig.productActionMap.get(number);
        if (action != null) {
            return action;
        }
        System.out.println("Нет такого действия");
        return getAction();
    }

    @Override
    public void showMenu() {
        for (Map.Entry<Integer, Action> oneActionEntry : ConsoleConfig.productActionMap.entrySet()) {
            System.out.printf("%s - %s\n", oneActionEntry.getKey(), oneActionEntry.getValue().getName());

        }
    }
}

