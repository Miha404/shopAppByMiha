package com.company.config;

import com.company.view.action.*;

import java.util.HashMap;
import java.util.Map;

public class ConsoleConfig {
    public static Map<Integer, Action> productActionMap = new HashMap<>();
    public static Map<Integer, Action> userActionMap = new HashMap<>();

    static {
        productActionMap.put(1, new AddProductAction());
        productActionMap.put(2, new ShowProductAction());
        productActionMap.put(3, new RemoveProductAction());
        productActionMap.put(4, new UpdateProductAction());
        productActionMap.put(5, new ExitProgram());
    }
    static {
        userActionMap.put(1, new UserLogInAction());
        userActionMap.put(2, new CreateNewUserAccount());
        userActionMap.put(3, new ExitProgram());
    }
}
