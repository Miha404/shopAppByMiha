package com.company.view.action;

import com.company.controller.ProductController;
import com.company.model.Product;
import com.company.view.console.Input;

public class RemoveProductAction extends BaseAction implements Action {

    @Override
    public String getName() {
        return "Удалить товар";
    }

    @Override
    public void execute() {
        String name = Input.getString("Введите название продукта");
        Product revomeProduct = getRemoveProduct(name);
        if (revomeProduct != null) {
            productController.remove(revomeProduct);
        } else {
            System.out.println("Такого товара не найдено.");
        }
    }

    private Product getRemoveProduct(String name) {

        for (int i = 0; i < productController.get().size(); i++) {
            if (name.equals(productController.get().get(i).getName())) {
                return productController.get().get(i);
            }
        }
        return null;
    }
}
