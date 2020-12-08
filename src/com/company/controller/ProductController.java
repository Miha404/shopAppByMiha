package com.company.controller;

import com.company.dao.ProductDao;
import com.company.dao.ProductDaoMemory;
import com.company.exception.DuplicateProductException;
import com.company.model.Product;

import java.util.List;

public class ProductController {
    private ProductDao productDao = new ProductDaoMemory();

    public void add(Product product) throws DuplicateProductException {
        productDao.add(product);
    }

    public List<Product> get() {
        return productDao.get();
    }

    public void remove(Product product) {
        productDao.remove(product);
    }

    public void update(int indexUpdate, Product product) {
        productDao.update(indexUpdate, product);
    }
}
