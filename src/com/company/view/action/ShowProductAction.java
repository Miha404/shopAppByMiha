package com.company.view.action;

import com.company.model.Product;

import java.util.List;

public class ShowProductAction extends BaseAction implements Action {
    @Override
    public String getName() {
        return "Получить список существующих товаров";
    }

    @Override
    public void execute() {
        List<Product> productList = productController.get();
        System.out.println("=============================");
        productList.forEach(System.out:: println);
        System.out.println("=============================");
    }
}
