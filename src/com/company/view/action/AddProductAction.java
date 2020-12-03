package com.company.view.action;

import com.company.exception.DuplicateProductException;
import com.company.model.Product;
import com.company.view.console.Input;

public class AddProductAction extends BaseAction implements Action {
    @Override
    public String getName() {
        return "Добавить товар";
    }

    @Override
    public void execute() {
        int id = Input.getInt("Введите ID продукта");
        String name = Input.getString("Введите название продукта");
        double price = Input.getDouble("Введите цену продукта");
        Product product = new Product(id, name, price);
        try {
            productController.add(product);
        } catch (DuplicateProductException exception){
            System.out.println(exception.getMessage());
        }
    }
}
