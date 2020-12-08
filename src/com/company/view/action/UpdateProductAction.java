package com.company.view.action;

import com.company.model.Product;
import com.company.view.console.Input;

public class UpdateProductAction extends BaseAction implements Action {
    @Override
    public String getName() {
        return "Обновить информацию о товаре";
    }

    @Override
    public void execute() {
        String name = Input.getString("Введите название продукта");
        int updateProductIndex = getUpdateProductIndex(name);
        if (updateProductIndex != -1){
            String newName = Input.getString("Введите новое название продукта");
            double newPrice = Input.getDouble("Введите цену продукта");
            Product updateProduct = new Product(productController.get().get(updateProductIndex).getId(), newName, newPrice);
            productController.update(updateProductIndex, updateProduct);
        }else {
            System.out.println("Такой товар не найден");
        }
    }

    private int getUpdateProductIndex(String name) {
        int index;
            for (int i = 0; i < productController.get().size(); i++) {
                if (name.equals(productController.get().get(i).getName())) {
                    index = i;
                    return index;
                }
            }
        return -1;
    }
}
