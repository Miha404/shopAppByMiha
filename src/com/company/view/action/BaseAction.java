package com.company.view.action;

import com.company.controller.ProductController;
import com.company.controller.UserController;

public class BaseAction {
    protected ProductController productController = new ProductController();
    protected UserController userController = new UserController();
}
