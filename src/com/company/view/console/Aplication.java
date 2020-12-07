package com.company.view.console;

import com.company.config.ConsoleConfig;
import com.company.view.action.Action;

import java.util.Map;

public class Aplication {
    public void start() {
        System.out.println("Добро пожаловать в мое первое консольное приложение!");
        run();
        System.out.println("Работа приложения окончена.");
    }

    private void run() {
        System.out.println("Для начала Вам нужно зарегистрироваться или зайти в свой аккаунт.");
        while (true) {
            Action action = getAction();
            action.execute();
        }
    }

    private Action getAction() {
        showMenu();
        int number = Input.getInt("Выберите номер действия");
        Action action = ConsoleConfig.actionMap.get(number);
        if (action != null) {
            return action;
        }
        System.out.println("Нет такого действия");
        return getAction();
    }

    private void showMenu() {
        for (Map.Entry<Integer, Action> oneActionEntry : ConsoleConfig.actionMap.entrySet()) {
            System.out.printf("%s - %s\n", oneActionEntry.getKey(), oneActionEntry.getValue().getName());

        }
    }
}

