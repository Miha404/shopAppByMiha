package com.company.dao;

import com.company.exception.DuplicateProductException;
import com.company.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductDaoMemory implements ProductDao {
    private static List<Product> productList;
  // singlTone pattern
    private static List<Product> getProductList(){
        if (productList == null) {
            productList = new ArrayList<>();
            productList.add(new Product(1, "headphone", 20));
            productList.add(new Product(2, "MacBook", 1200));
        }
        return productList;
    }

    @Override
    public void add(Product product) throws DuplicateProductException {
        if (getProductList().contains(product)){
            throw new DuplicateProductException(product.getId());
        }
        getProductList().add(product);
    }

    @Override
    public List<Product> get() {
        return new ArrayList<>(getProductList());
    }

    @Override
    public void remove(Product product) {
        getProductList().remove(product);
    }

    @Override
    public void update(int indexToUpdate, Product product) {
        int index = getProductList().indexOf(product);
        if (index != -1){
            getProductList().set(index, product);
        }

    }
}
