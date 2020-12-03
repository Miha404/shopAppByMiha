package com.company.dao;

import com.company.exception.DuplicateProductException;
import com.company.model.Product;

import java.util.List;

public interface ProductDao {
    void add(Product product) throws DuplicateProductException;
    List<Product> get();
    void remove(Product product);
    void update(Product product);

}
