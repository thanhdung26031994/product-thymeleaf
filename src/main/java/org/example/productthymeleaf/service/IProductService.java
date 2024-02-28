package org.example.productthymeleaf.service;

import org.example.productthymeleaf.model.Product;

import java.util.List;

public interface IProductService {


    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Integer id, Product product);

    void remove(Integer id);
}
