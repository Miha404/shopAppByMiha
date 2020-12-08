package com.company;

import com.company.exception.DuplicateUserException;
import com.company.view.console.RunApplication;
import com.company.view.console.StartApplication;

public class Main {

    public static void main(String[] args) throws DuplicateUserException {
        StartApplication application  = new StartApplication();
        application.start();
        if (StartApplication.enterAccess = true){
            RunApplication application1 = new RunApplication();
            application1.applicationRun();
        }
    }
}
