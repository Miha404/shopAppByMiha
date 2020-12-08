package com.company.view.action;

import com.company.view.console.RunApplication;
import com.company.view.console.StartApplication;

import java.sql.SQLOutput;

public class ExitProgram extends BaseAction implements Action {


    @Override
    public String getName() {
        return "Выйти из программы.";
    }

    @Override
    public void execute() {
        System.out.println("Работы приложения окончена.");
        StartApplication.go = false;
    }
}
