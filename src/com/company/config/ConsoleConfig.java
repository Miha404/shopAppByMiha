package com.company.config;

import com.company.view.action.*;

import java.util.HashMap;
import java.util.Map;

public class ConsoleConfig {
    public static Map<Integer, Action> actionMap = new HashMap<>();

    static {
        actionMap.put(1, new AddProductAction());
        actionMap.put(2, new ShowProductAction());
        actionMap.put(3, new RemoveProductAction());
        actionMap.put(4, new UpdateProductAction());
    }
}
